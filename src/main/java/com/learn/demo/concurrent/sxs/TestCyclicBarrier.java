package com.learn.demo.concurrent.sxs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Employee implements Runnable {
    private String name;
    private CyclicBarrier barrier;

    public Employee(String name, final CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    public void run() {
        try {
            System.out.println(name + "已经到达万达商场等待");
            barrier.await(); //等待最后一个线程到达（底层会去判断）
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name + "上车");
    }
}

public class TestCyclicBarrier {
    public static void main(String[] args) {
        int num = 3;
        String[] strs = {"主管", "小明", "小王"};
        CyclicBarrier barrier = new CyclicBarrier(num);
        for (int i = 0; i < num; i++) {
            new Thread(new Employee(strs[i], barrier)).start();
        }
    }
}