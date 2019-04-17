package com.learn.demo.concurrent.xiaomage.collection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronousQueueQuiz {

    public static void main(String[] args) throws Exception {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        // 1. SynchronousQueue 是无空间，offer 永远返回 false
        // 2. SynchronousQueue take() 方法会被阻塞，必须被其他线程显示地调用 put(Object);
        System.out.println("queue.offer(1) = " + queue.offer(1));
        System.out.println("queue.offer(2) = " + queue.offer(2));
        System.out.println("queue.offer(3) = " + queue.offer(3));

        // 以下为新建线程重新为SynchronousQueue赋值
//        AtomicInteger atomicInteger = new AtomicInteger();
//        for (int i=0 ;i<3; i++ ){
//            int andIncrement = atomicInteger.getAndIncrement();
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        queue.offer(andIncrement);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    // 可以在单个子线程中进行相关赋值，也可以分别赋值，take()为空时会造成阻塞。
                    queue.put(99);
//                    queue.put(99);
//                    queue.put(99);
//                    queue.put(99);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    queue.put(77);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    queue.put(88);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread3.start();

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    queue.put(66);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread4.start();

        System.out.println("queue.take() = " + queue.take());
        System.out.println("queue.take() = " + queue.take());
        System.out.println("queue.take() = " + queue.take());
        System.out.println("queue.take() = " + queue.take());
        System.out.println("queue.size = " + queue.size());
        System.out.println("queue = " + queue);
    }
}
