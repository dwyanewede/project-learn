package com.learn.demo.java.spi;
/**
 * @ClassName: Bumblebee
 * @Description: Robot接口服务实现类
 * @Author: 尚先生
 * @CreateDate: 2019/3/17 10:59
 * @Version: 1.0
 */
public class Bumblebee implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}