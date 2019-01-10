package com.learn.demo.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread("老二") {
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + "吃完了");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ;
        }.start();
        new Thread("老大") {
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + "吃完了");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ;
        }.start();
        new Thread("老爸") {
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + "吃完了");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ;
        }.start();
        System.out.println("等待三个男人吃完,女人才能上桌吃饭,等....");
        try {
            countDownLatch.await(10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("女人们可以上桌吃饭了");
    }
}