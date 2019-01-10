package com.learn.demo.design.pattern;


/**
 * @ClassName: LanbdaDemo
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/18 16:45
 * @Version: 1.0
 */
public class LanbdaDemo {

    public static void main(String[] args) {

        echo(() -> "hello world");
    }

    public static void echo(Valueable<?> valueable){
        System.out.println(valueable.get());
    }

    public static interface Valueable<V>{
        V get();
    }
}
