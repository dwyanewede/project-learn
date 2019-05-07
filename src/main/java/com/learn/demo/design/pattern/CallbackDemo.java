package com.learn.demo.design.pattern;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: ExecutorsDemo
 * @Description: 回调接口
 * @Author: 尚先生
 * @CreateDate: 2018/12/18 8:37
 * @Version: 1.0
 */
public class CallbackDemo {

    public static void main(String[] args) {

//        ExecutorService executorService =
//                Executors.newSingleThreadExecutor();
//        Future<String> future = executorService.submit(() -> {
//            return "hello world";
//        });

        // 同步执行
        sync();

        // 异步执行
        async();

    }

    private static void sync() {


        CallbackExecutor callbackExecutor = new CallbackExecutor();

        Optional.ofNullable(callbackExecutor).get().execute(() -> System.out.println("自定义执行器..."));

        callbackExecutor.execute(() -> {
            System.out.println("hello world 1");
        });
        callbackExecutor.execute(() -> {
            System.out.println("hello world 2");
        });
        callbackExecutor.run();
        System.out.println("同步回调...");
    }

    private static void async() {
        ExecutorService executorService =
                Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World 1 !");
            }
        });
        executorService.execute(() ->{
            System.out.println("Hello World 2 !");
        });

//        executorService.execute(() ->{
//            throw new RuntimeException("手动抛出的异常...");
//        });

        System.out.println("异步回调...");
        executorService.shutdown();
    }

    public interface Callback {
        void callback();
    }

    public static class CallbackExecutor {

        private Queue<Callback> callbackQueue = new LinkedList<>();

        public void execute(Callback callback) {

            callbackQueue.add(callback);
        }

        public void run() {
            callbackQueue.forEach(callback -> callback.callback());
        }
    }

}
