package com.learn.demo.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName: RegistryProvider
 * @Description: 自定义处理器
 * @Author: 尚先生
 * @CreateDate: 2019/1/10 8:52
 * @Version: 1.0
 */
public class ProviderHandlers extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        INvokeMsg message = (INvokeMsg)msg;
        if (!classCache.contains(message.getClassName())){return;}
        Object clazz =  registerMap.get(message.getClassName());

        Method method = clazz.getClass().getMethod(message.getMethodName(),message.getParamTypes());

        Object invoke = method.invoke(clazz, message.getArgs());
        ctx.writeAndFlush(invoke);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    public ProviderHandlers() {
        scannClass("com.learn.demo.netty.provider");
        register();
    }

    // 创建注册中心
    private ConcurrentHashMap<String,Object> registerMap = new ConcurrentHashMap<>();

    // 将扫的类名存储
    private Queue<String> classCache = new LinkedBlockingQueue<>();


    /**
     * IOC容器初始化
     * 扫描出所有的Class
     * @param packages
     */
    private void scannClass(String packages){

        URL url = this.getClass().getClassLoader().getResource(packages.replaceAll("\\.", "/"));
        File dir = new File(url.getFile());
        for (File file1:dir.listFiles()){
            if (file1.isDirectory()){
                scannClass(packages + "." + file1.getName());
            }else {
                String className = packages + "." + file1.getName().replaceAll(".class", "").trim();
                classCache.add(className);
            }
        }
    }

    // 开始注册
    private void register(){
        if (classCache.isEmpty()){return;}
        classCache.forEach(className -> {
            try {
                Class<?> clazz = Class.forName(className);
                Class<?> clazzInterface = clazz.getInterfaces()[0];
                registerMap.put(clazzInterface.getName(),clazz.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
