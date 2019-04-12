package com.learn.demo.test;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName: TestBlockingQueue
 * @Description: 阻塞但是不报错方式存取元素
 * @Author: 尚先生
 * @CreateDate: 2019/4/12 8:56
 * @Version: 1.0
 */
public class TestBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>(3);
        // LinkedBlockingQueue 阻塞但是不报错方式存取元素 put、take
        for(int i=0; i<5; i++){
            blockingQueue.put(i);
            if (i%2 == 0){
                blockingQueue.take();
            }
        }
        Iterator<Integer> iterator = blockingQueue.iterator();

        iterator.forEachRemaining(num -> System.out.println(num));
    }
}
