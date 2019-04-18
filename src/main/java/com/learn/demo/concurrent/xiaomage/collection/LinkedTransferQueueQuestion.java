package com.learn.demo.concurrent.xiaomage.collection;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @ClassName: LinkedTransferQueueQuestion
 * @Description: LinkedTransferQueue 与 LinkedBlockingQueue 相比有直接存取的优势
 *               与 SynchronousQueue 相比有队列存取优势
 * @Author: 尚先生
 * @CreateDate: 2019/4/18 8:40
 * @Version: 1.0
 */
public class LinkedTransferQueueQuestion {

    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<Integer> transferQueue = new LinkedTransferQueue<>();
        for (int i=0; i<10; i++){
            transferQueue.offer(i);
        }

        System.out.println(" size: " +transferQueue.size());
//        transferQueue.transfer(20);
        transferQueue.tryTransfer(66);

        System.out.println(" tryTransfer size: " +transferQueue.size());
        transferQueue.forEach(con -> System.out.println(con));
    }

}
