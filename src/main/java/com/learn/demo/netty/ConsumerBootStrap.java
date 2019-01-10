package com.learn.demo.netty;

import com.learn.demo.netty.service.DemoService;

/**
 * @ClassName: ConsumerBootStrap
 * @Description: 自定义RPC框架客户端
 * @Author: 尚先生
 * @CreateDate: 2019/1/10 10:39
 * @Version: 1.0
 */
public class ConsumerBootStrap {

    public static void main(String[] args) {

        DemoService service = ConsumerProxy.createProxy(DemoService.class);
        System.out.println(service.getClass().getSimpleName() + "--------------");
        String res = service.sayHello("尚先生");
        System.out.println(res);

    }
}
