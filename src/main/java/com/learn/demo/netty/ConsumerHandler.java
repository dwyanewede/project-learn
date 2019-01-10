package com.learn.demo.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @ClassName: ConsumerHandler
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2019/1/10 11:09
 * @Version: 1.0
 */
public class ConsumerHandler extends ChannelInboundHandlerAdapter {

    private Object result;
    public Object getResult(){
        return this.result;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        this.result = msg;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}
