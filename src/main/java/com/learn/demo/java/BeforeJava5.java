package com.learn.demo.java;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BeforeJava5 {

    public static void main(String[] args) throws InterruptedException {
        // 创建线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.printf("当前线程 Thread：%s, hello world...\n", Thread.currentThread().getName());
            }
        });
        // 启动线程
        thread.start();
        // 串行化操作
        thread.join();
        System.out.printf("当前线程 Thread：%s, start...\n", Thread.currentThread().getName());
        testjava5();
    }

    private static void testjava5() {

        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis());
            }
        };
        threadPool.scheduleAtFixedRate(runnable,0, 5, TimeUnit.SECONDS);

        threadPool.submit(runnable);

    }

}
