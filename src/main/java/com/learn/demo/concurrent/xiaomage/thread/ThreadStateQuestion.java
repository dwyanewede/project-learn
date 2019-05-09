package com.learn.demo.concurrent.xiaomage.thread;

import java.util.concurrent.TimeUnit;

public class ThreadStateQuestion {


    public static void main(String[] args) throws InterruptedException {

        // main 线程 -> 子线程
        Thread thread = new Thread(() -> { // new Runnable(){ public void run(){...}};
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("线程[%s] 正在执行...\n", Thread.currentThread().getName());  // 2
        }, "子线程-1");

        // 启动线程
        thread.start();

        // 若调用 sleep()而使线程处于 TIMED-WATING 状态，这时调用 interrupt()方法，会抛出
        //InterruptedException,
        thread.interrupt();

        // 先于 Runnable 执行
        System.out.printf("线程[%s] 是否还活着: %s\n", thread.getName(), thread.isAlive()); // 1
        // 在 Java 中，执行线程 Java 是没有办法销毁它的，
        // 但是当 Thread.isAlive() 返回 false 时，实际底层的 Thread 已经被销毁了
    }
}
