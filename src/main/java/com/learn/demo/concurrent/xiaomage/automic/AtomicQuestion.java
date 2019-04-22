package com.learn.demo.concurrent.xiaomage.automic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicQuestion {

    private static int actualValue = 3;

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(3);
        System.out.println("atomicInteger原始值为：" + atomicInteger);
        // if( value == 3 )
        //     value = 5
        atomicInteger.compareAndSet(3, 5);
        System.out.println("atomicInteger更新后的值为：" + atomicInteger);
        // 偏向锁 < CAS 操作 < 重锁（完全互斥）
        // CAS 操作也是相对重的操作，它也是实现 synchronized 瘦锁(thin lock)的关键
        // https://wiki.openjdk.java.net/display/HotSpot/Synchronization
        // 偏向锁就是避免 CAS（Compare And Set/Swap)操作
        // 汇编指令：cpmxchg
    }

    private synchronized static void compareAndSet(int expectedValue, int newValue) {
        if (actualValue == expectedValue) {
            actualValue = newValue;
        }
    }
}