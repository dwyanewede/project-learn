package com.learn.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: WaitAndNotify
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/27 18:19
 * @Version: 1.0
 */
public class WaitAndNotify {

    public static void main(String[] args) {

        Object obj = new Object();
        WaitDemo waitDemo = new WaitDemo(obj);
        NotifyDemo notifyDemo = new NotifyDemo(obj);
        waitDemo.start();
        notifyDemo.start();
    }

    static class WaitDemo extends Thread {

        private Object obj;

        public WaitDemo(Object obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("wait class starting...");
                try {
                    obj.wait();
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait class completed...");
            }
        }
    }

    static class NotifyDemo extends Thread {

        private Object obj;

        public NotifyDemo(Object obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("notify class starting...");
                obj.notify();
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("notify class completed...");
            }
        }
    }
}
