package com.learn.demo.service;

import com.learn.demo.netty.service.DemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProviderBootstrap {

    public static void main(String[] args) {
        // 创建 Annotation 配置上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册配置 Bean
        context.register(ProviderConfiguration.class);
        // 启动上下文
        context.refresh();
        // 获取 DemoService Bean
        DemoService demoService = context.getBean(DemoService.class);
        // 执行 sayHello 方法
        String message = demoService.sayHello("World");
        // 控制台输出信息
        System.err.println(message);
    }
    
}