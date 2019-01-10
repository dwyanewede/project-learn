package com.learn.demo.service;

import com.learn.demo.demo.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AnnotationDemoService implements DemoService {
    // 省略实现，保持不变
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

}