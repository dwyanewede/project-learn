package com.learn.demo.concurrent.xiaomage.thread;

import java.util.concurrent.TimeUnit;

public class ThreadExceptionQuestion {

    public static void main(String[] args) throws InterruptedException {

        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            System.out.printf("线程[%s] 遇到了异常，详细信息：%s\n",
                    thread.getName(),
                    throwable.getMessage());
        });

        // main 线程 -> 子线程
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("数据达到阈值");
        }, "t1");

        t1.start();
        System.out.println(t1.isAlive());
        // main 线程会中止吗？ 可以控制顺序执行
        t1.join();

        // Java Thread 是一个包装，它由 GC 做垃圾回收
        // JVM Thread 可能是一个 OS Thread，JVM 管理，
        // 当线程执行完毕（正常或者异常）
        System.out.println(t1.isAlive());
    }
}
