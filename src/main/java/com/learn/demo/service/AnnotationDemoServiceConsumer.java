package com.learn.demo.service;

import org.apache.dubbo.config.annotation.Reference;

public class AnnotationDemoServiceConsumer {

    @Reference(url = "dubbo://127.0.0.1:12345")
    private DemoService demoService;

    public String doSayHello(String name) {
        return demoService.sayHello(name);
    }
}