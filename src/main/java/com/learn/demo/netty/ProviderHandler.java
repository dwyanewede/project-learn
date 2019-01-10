package com.learn.demo.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName: ProviderHandler 可以继承 ChannelInboundHandlerAdapter
 * @Description: 自定义处理器
 * @Author: 尚先生
 * @CreateDate: 2019/1/10 9:03
 * @Version: 1.0
 */
public class ProviderHandler extends SimpleChannelInboundHandler {

    public ProviderHandler() {
        scannClass("com.learn.demo.netty.provider");
        register();
    }

    // 创建注册中心
    private ConcurrentHashMap<String,Object> registerMap = new ConcurrentHashMap<>();

    // 将扫的类名存储
    private Queue<String>  classCache = new LinkedBlockingQueue<>();

    /*@Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        INvokeMsg message = (INvokeMsg)msg;

        if (!classCache.contains(message.getClassName())){return;}
        Object clazz =  registerMap.get(message.getClassName());

        Method method = clazz.getClass().getMethod(message.getMethodName(),message.getParamTypes());

        Object invoke = method.invoke(clazz, message.getArgs());
        ctx.writeAndFlush(invoke);
        ctx.close();


    }*/


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        Object result = new Object();

        //客户端传过来的调用信息
        INvokeMsg request = (INvokeMsg)msg;
        if(registerMap.containsKey(request.getClassName())){
            Object clazz = registerMap.get(request.getClassName());

            Method m = clazz.getClass().getMethod(request.getMethodName(), request.getParamTypes());
            result = m.invoke(clazz, request.getArgs());
        }

        ctx.writeAndFlush(result);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

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
