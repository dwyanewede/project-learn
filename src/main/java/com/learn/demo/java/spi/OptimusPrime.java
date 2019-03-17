package com.learn.demo.java.spi;
/**
 * @ClassName: OptimusPrime
 * @Description: Robot接口服务实现类
 * @Author: 尚先生
 * @CreateDate: 2019/3/17 10:59
 * @Version: 1.0
 */
public class OptimusPrime implements Robot {
    
    @Override
    public void sayHello() {
        System.out.println("Hello, I am Optimus Prime.");
    }
}