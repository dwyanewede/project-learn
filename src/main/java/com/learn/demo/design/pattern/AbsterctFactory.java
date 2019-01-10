package com.learn.demo.design.pattern;

import java.util.concurrent.ThreadFactory;

/**
 * @ClassName: AbsterctFactory
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/17 20:03
 * @Version: 1.0
 */
public abstract class AbsterctFactory {

    //1. 接口或抽象类
    //2. 创建实例
    //3. 抽象方法
    // ThreadFactory


    public static void main(String[] args) {
        ThreadFactory factory = (t) -> {
            return new Thread(t);
        };
        Thread thread = factory.newThread(() -> {
            System.out.println("------------------");
        });
        thread.start();
    }
}
