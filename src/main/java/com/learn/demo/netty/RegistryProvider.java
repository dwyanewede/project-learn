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

/**
 * @ClassName: RegistryProvider
 * @Description: 自定义RPC框架服务端
 * @Author: 尚先生
 * @CreateDate: 2019/1/10 8:52
 * @Version: 1.0
 */
public class RegistryProvider {

    private int port;

    public RegistryProvider(int port) {
        this.port = port;
    }

    public static void main(String[] args) {

        RegistryProvider provider = new RegistryProvider(8080);
        provider.run();

    }

    public void run() {

        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();

        try {
            b.group(boosGroup,workGroup);
            b.channel(NioServerSocketChannel.class);
            b.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline p = ch.pipeline();
                   // 拆包粘包
                    p.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
                    p.addLast(new LengthFieldPrepender(4));
                    // 序列化
                    p.addLast("encoder",new ObjectEncoder());
                    p.addLast("decode",new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                    // 自定义handler
                    p.addLast(new ProviderHandler());
                }
            })
            .option(ChannelOption.SO_BACKLOG,128)
            .childOption(ChannelOption.SO_KEEPALIVE,true);;

            ChannelFuture future = b.bind(this.port).sync();
            System.err.println("my netty server start...");
            future.channel().closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            boosGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
