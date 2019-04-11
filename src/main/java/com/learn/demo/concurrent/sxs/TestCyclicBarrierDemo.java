package com.learn.demo.concurrent.sxs;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * > CountDownLatch
 * > Semaphore
 * > Exchanger
 * > CyclicBarrier
 */
public class TestCyclicBarrierDemo {
    public static void main(String[] args) {
        int num = 5;
        CyclicBarrier barrier = new CyclicBarrier(num, new Leader());
        for (int i = 0; i < num; i++) {
            new Thread(new Employees(barrier,i)).start();
        }
    }
}

class Leader implements Runnable {
    @Override
    public void run() {
        System.out.println("吃饭前我先说几句");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Employees implements Runnable {

    private CyclicBarrier barrier;

    private int num;

    public Employees(CyclicBarrier barrier, int num) {
        this.barrier = barrier;
        this.num = num;
    }

    public void run() {
        try {
            System.out.println("员工 " + num + " 在等老板说完话准备吃");
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("老板说了15分钟 " + "员工 " + num + " 开始吃了");
    }
}