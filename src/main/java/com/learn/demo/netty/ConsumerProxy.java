package com.learn.demo.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: ConsumerProxy
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2019/1/10 10:40
 * @Version: 1.0
 */
public class ConsumerProxy {

    public static <T> T createProxy(Class<?> clazz) {
        SimpleInvokecation invokecation = new SimpleInvokecation(clazz);

        T result = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, invokecation);

        return result;
    }
}

class SimpleInvokecation implements InvocationHandler {

    private Class<?> clazz;

    public SimpleInvokecation(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 传进来的是实现类则直接调用
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }
        // 传进来的是接口则远程调用
        return remoteInvocate(method, args);
    }

    private Object remoteInvocate(Method method, Object[] args) {
        INvokeMsg msg = new INvokeMsg();
        msg.setClassName(clazz.getName());
        msg.setMethodName(method.getName());
        msg.setParamTypes(method.getParameterTypes());
        msg.setArgs(args);
        final ConsumerHandler handler = new ConsumerHandler();
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();

                            //处理的拆包、粘包的解、编码器
                            pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                            pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));

                            //处理序列化的解、编码器（JDK默认的序列化）
                            pipeline.addLast("encoder", new ObjectEncoder());
                            pipeline.addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));

                            //自己的业务逻辑
                            pipeline.addLast("handler", handler);
                        }

                    });
            ChannelFuture f = b.connect("localhost", 8080).sync();
            f.channel().writeAndFlush(msg).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
        return handler.getResult();
    }
}
