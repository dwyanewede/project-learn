package com.learn.demo.thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liujinhong on 2017/4/2.
 * 生产者消费者问题是一个很经典的问题，值得好好研究一下
 * java的wait和notify方法在使用时也是要非常注意的
 */
public class ProducerConsumer {
    public static class Producer extends Thread {
        Queue<Integer> queue;
        int maxsize;

        Producer(Queue<Integer> queue, int maxsize, String name) {
            this.queue = queue;
            this.maxsize = maxsize;
            this.setName(name);
        }
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    try{
                        Thread.sleep(500);
                    } catch (Exception e) {}

                    System.out.println(this.getName() + "获得队列的锁");
                    //条件的判断一定要使用while而不是if
                    if (queue.size() == maxsize) {
                        System.out.println("队列已满，生产者" + this.getName() + "等待");
                        try {
                            queue.wait();
                        } catch (Exception e) {}
                    }
                    int num = (int)(Math.random()*100);
                    queue.offer(num);

                    System.out.println(this.getName() + "生产一个元素：" + num);
                    queue.notifyAll();

                    System.out.println(this.getName() + "退出一次生产过程！");
                }
            }
        }
    }

    public static class Consumer extends Thread {
        Queue<Integer> queue;
        int maxsize;

        Consumer(Queue<Integer> queue, int maxsize, String name) {
            this.queue = queue;
            this.maxsize = maxsize;
            this.setName(name);
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    try{
                        Thread.sleep(500);
                    } catch (Exception e) {}

                    System.out.println(this.getName() + "获得队列的锁");
                    //条件的判断一定要使用while而不是if
                    if (queue.isEmpty()) {
                        System.out.println("队列为空，消费者" + this.getName() + "等待");
                        try{
                            queue.wait();
                        } catch (Exception e) {}
                    }
                    int num = queue.poll();
                    System.out.println(this.getName() + "消费一个元素："+num);
                    queue.notifyAll();

                    System.out.println(this.getName() + "退出一次消费过程！");
                }
            }
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int maxsize = 2;

        Producer producer = new Producer(queue, maxsize, "Producer");
        Consumer consumer1 = new Consumer(queue, maxsize,"Consumer1");
        Consumer consumer2 = new Consumer(queue, maxsize,"Consumer2");
        Consumer consumer3 = new Consumer(queue, maxsize,"Consumer3");

        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}