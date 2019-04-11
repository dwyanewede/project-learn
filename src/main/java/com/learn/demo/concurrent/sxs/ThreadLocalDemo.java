package com.learn.demo.concurrent.sxs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: ThreadLocalDemo
 * @Description: ThreadLocal、InheritableThreadLocal测试
 * @Author: 尚先生
 * @CreateDate: 2019/2/22 10:31
 * @Version: 1.0
 */
public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {
        testThreadLocal();
        TimeUnit.SECONDS.sleep(1);
        System.err.println("-------------分割线---------------");
        testInheritableThreadLocal();
    }

    /**
     * 测试testInheritableThreadLocal父子类线程变量取值
     */
    private static void testInheritableThreadLocal() {
        //模拟多线程创建ThreadLocal
        for (int i = 0; i < 3; i++) {
            new Thread("currentThread-InheritableThreadLocal" + i) {
                @Override
                public void run() {
                    System.out.println("当前线程：" + Thread.currentThread().getName() + " ID：" + MyInheritableThreadLocal.get());
                    for (int j = 0; j < 3; j++) {
                        new Thread("subThread-InheritableThreadLocal" + j) {
                            @Override
                            public void run() {
                                System.out.println("子线程：" + Thread.currentThread().getName() + " ID：" + MyInheritableThreadLocal.get());
                            }
                        }.start();
                    }
                }
            }.start();
        }
    }


    /**
     * 测试ThreadLocal父子类线程变量取值
     */
    private static void testThreadLocal() {
        //模拟多线程创建ThreadLocal
        for (int i = 0; i < 3; i++) {
            new Thread("currentThread-ThreadLocal" + i) {
                @Override
                public void run() {
                    System.out.println("当前线程：" + Thread.currentThread().getName() + " ID：" + MyThreadLocal.get());
                    for (int j = 0; j < 3; j++) {
                        new Thread("subThread-ThreadLocal" + j) {
                            @Override
                            public void run() {
                                System.out.println("子线程：" + Thread.currentThread().getName() + " ID：" + MyThreadLocal.get());
                            }
                        }.start();
                    }
                }
            }.start();
        }
    }

    /**
     * 自定义ThreadLocal实现
     */
    static class MyThreadLocal {
        private static final AtomicInteger nextId = new AtomicInteger(0);

        private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return nextId.getAndIncrement();
            }
        };

        public static int get() {
            return threadId.get();
        }
    }

    /**
     * 自定义InheritableThreadLocal实现
     */
    static class MyInheritableThreadLocal {
        private static final AtomicInteger nextId = new AtomicInteger(0);
        private static final InheritableThreadLocal<Integer> threadId = new InheritableThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return nextId.getAndIncrement();
            }
        };

        public static int get() {
            return threadId.get();
        }
    }

}

