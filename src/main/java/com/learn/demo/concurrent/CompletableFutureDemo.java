package com.learn.demo.concurrent;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. 完成操作可以被其他线程去做
//        CompletableFuture<String> completableFuture = new CompletableFuture<>();
//        completableFuture.complete("hello world");
//        String value = completableFuture.get();
//        System.out.printf("当前线程 Thread：%s,hello world...  %s\n",Thread.currentThread().getName(),value);

        // 2. 异步执行，阻塞操作
//        CompletableFuture runAsyncCompletableFuture = CompletableFuture.runAsync(()->{
//            String name = Thread.currentThread().getName();
//            System.out.println("Thread: " + name + " --hello world");
//        });
//        //保证执行顺序 hello world 输出在前  实际上还是阻塞主线程
//        runAsyncCompletableFuture.get();
//        System.out.println("staring...");

        // 3. 异步执行，非阻塞操作
//        CompletableFuture<String> supplyAsyncCompletableFuture = CompletableFuture.supplyAsync(()->{
//           // 假设是耗时操作 如：数据库查询
//            return String.format("当前线程 Thread：%s, hello world...\n",Thread.currentThread().getName());
//        });
//        String value = supplyAsyncCompletableFuture.get();
//        System.out.println("value = " + value);
//        System.out.println("staring...");

        // 4. 合并操作
        CompletableFuture combainCompletableFuture = CompletableFuture.supplyAsync(()->{
            // 假设是耗时操作 如：数据库查询
            return String.format("当前线程 Thread：%s, hello world...\n",Thread.currentThread().getName());
        }).thenApply(value ->{
            return value + "数据库查询";
        }).thenApply(value ->{
            return value + LocalDate.now();
        }).thenApply(value ->{
            System.out.printf("当前线程 Thread：%s, hello world...\n",Thread.currentThread().getName());
            return value;
        }).thenRun(() ->{
            System.out.println("操作完成");
            throw new RuntimeException("抛一个异常");
            // Java 8 异常处理
        }).exceptionally(e -> {
            System.out.println(e);
            return null;
        });
//        combainCompletableFuture.get();
        System.out.println("staring...");
        while (!combainCompletableFuture.isDone()){}
    }
}