package com.learn.demo.design.pattern;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @ClassName: Java8CallbackDemo
 * @Description: java 8 Lambda 实现 CallbackDemo
 * @Author: 尚先生
 * @CreateDate: 2019/5/8 9:54
 * @Version: 1.0
 */
public class Java8CallbackDemo {
    // 定义全局并发安全队列
    public static LinkedBlockingQueue<Callback> queues = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 同步执行
        sync();
    }

    private static void sync() {
        // 初始化 InvokerHandler 对象
        InvokerHandler invokerHandler = new InvokerHandler();
        invokerHandler.execute((Java8CallbackDemo.Callback)() -> { System.out.println("hello world sync 1");},(function -> queues.add(function)));
        invokerHandler.execute((Java8CallbackDemo.Callback)() -> { System.out.println("hello world sync 2");},(function -> queues.add(function)));
        queues.forEach(queue -> invokerHandler.run(queue,Callback::callback));
        System.out.println("sync 同步回调...");
    }

    interface Callback {
        void callback();
    }

   static class InvokerHandler {
        public <T, R> R execute(T t, Function<T, R> function) {
            return function.apply(t);
        }

        public <T> void run(T t, Consumer<T> consumer) {
            consumer.accept(t);
        }
    }
}

