package com.learn.demo.design.pattern;


import java.util.function.Function;

/**
 * @ClassName: LambdaDemo
 * @Description: Lanbda示例代码
 * @Author: 尚先生
 * @CreateDate: 2018/12/18 16:45
 * @Version: 1.0
 */
public class LambdaDemo {

    public static void main(String[] args) {

        echo(() -> "hello world");
        System.out.println("---------------------");

        Function<LambdaDemo, String> printMsg = LambdaDemo::printMsg;
        String apply = printMsg.apply(new LambdaDemo());
        System.out.println(apply);
    }

    public String printMsg(){
        return "print message";
    }

    public static void echo(Valueable<?> valueable){
        System.out.println(valueable.get());
    }

    public static interface Valueable<V>{
        V get();
    }
}



