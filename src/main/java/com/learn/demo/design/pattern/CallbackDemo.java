package com.learn.demo.design.pattern;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * @ClassName: ExecutorsDemo
 * @Description: 回调接口设计
 * @Author: 尚先生
 * @CreateDate: 2018/12/18 8:37
 * @Version: 1.0
 */
public class CallbackDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // future 实现同步回调
        futures();

        // 同步执行
        sync();

        // 异步 Runnable 实现
        runnable();

        // 异步执行
        async();

    }

    private static void runnable() throws InterruptedException {
       new Thread(() -> System.out.println("hello world runnable 1")).start();
       new Thread(() -> {
           try {
               // 执行 RPC 或者 查询 DB 耗时操作
               TimeUnit.SECONDS.sleep(1);
               System.out.println("hello world runnable 2");
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           }).start();
       System.out.println("runnable 异步回调...");

    }

    private static void futures() throws ExecutionException, InterruptedException {
        ExecutorService executorService =
                Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            return "hello world future";
        });

        System.out.println(future.get());
        executorService.shutdown();
        System.out.println("future 同步回调...");
    }

    private static void sync() {
        CallbackExecutor callbackExecutor = new CallbackExecutor();

        Optional.ofNullable(callbackExecutor).get().execute(() -> System.out.println("自定义执行器..."));

        callbackExecutor.execute(() -> {
            System.out.println("hello world sync 1");
        });
        callbackExecutor.execute(() -> {
            System.out.println("hello world sync 2");
        });
        callbackExecutor.run();
        System.out.println("sync 同步回调...");
    }

    private static void async() {
        ExecutorService executorService =
                Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World async 1");
            }
        });
        executorService.execute(() ->{
            System.out.println("Hello World async 2");
        });

        executorService.execute(() ->{
            throw new RuntimeException("手动抛出的异常...");
        });

        System.out.println("async 异步回调...");
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
