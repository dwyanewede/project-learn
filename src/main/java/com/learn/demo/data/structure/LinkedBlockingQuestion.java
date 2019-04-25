package com.learn.demo.data.structure;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName: LinkedBlockingQuestion
 * @Description: LinkedBlockingQue使用，ReentrantLock实现并发控制
 * @Author: 尚先生
 * @CreateDate: 2019/4/25 16:51
 * @Version: 1.0
 */
public class LinkedBlockingQuestion {


    private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue(5);

    public static void main(String[] args) throws InterruptedException {

        testAdd();
        testOffer();
        testPeek();
        testPop();
        testTake();
        testPut();
        testRemove();
        testIterator();
        testclear();

    }

    private static void testclear() {
        int sizeBefore = queue.size();
        System.err.println("清空队列前，队列长度：" + sizeBefore);
        queue.clear();
        int sizeAfter = queue.size();
        System.err.println("清空队列后，队列长度：" + sizeAfter);
    }

    private static void testRemove() {
        // 队列为空时，获取数值会报错
        Integer integer = queue.remove();
        System.err.println("remove 删除结果：" + integer);
    }

    private static void testPop() {
        // 可设置超时获取时间，队列为空时返回null
        Integer poll = queue.poll();
        System.err.println("poll 获取结果：" + poll);
    }

    private static void testPut() throws InterruptedException {
        // 队列满时阻塞
        System.err.println("put 队列满时阻塞：" + 101);
        queue.put(101);
    }

    private static void testIterator() {
        queue.iterator().forEachRemaining(consumer -> System.out.println("LinkedBlockingQuestion 遍历结果: " + consumer));
    }

    /*
     * Walkthrough:
     * 1. If read count nonzero or write count nonzero
     *    and owner is a different thread, fail.
     * 2. If count would saturate, fail. (This can only
     *    happen if count is already nonzero.)
     * 3. Otherwise, this thread is eligible for lock if
     *    it is either a reentrant acquire or
     *    queue policy allows it. If so, update state
     *    and set owner.
     */
    private static void testTake() throws InterruptedException {
        // 当队列为空时阻塞当前线程
        // ReentrantLock + CAS 实现锁的获取
        Integer integer = queue.take();
        System.err.println("take 获取结果：" + integer);
    }

    private static void testPeek() {
        Integer integer = queue.peek();
        System.err.println("peek 获取结果：" + integer);
    }

    private static void testOffer() {
        queue.offer(100);
        queue.offer(4);
        boolean offer = queue.offer(6);
        // offer 方式添加队列满时 不报错
        System.err.println("队列已满 offer 添加结果：" + offer);
    }

    private static void testAdd() {
        boolean flag = queue.add(1);
        // add 方式添加队列满时 报错 "Queue full"
        System.err.println("队列未满 add 添加结果：" + flag);
        queue.add(3);
        queue.add(2);
        queue.add(5);
    }
}
