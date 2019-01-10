package com.learn.demo.netty.provider;


import com.learn.demo.netty.service.DemoService;

/**
 * @ClassName: DemoServiceImpl
 * @Description: 自定义RPC框架接口实现类
 * @Author: 尚先生
 * @CreateDate: 2019/1/7 18:52
 * @Version: 1.0
 */
//@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
