package com.learn.demo.thread.sendMsg;

import java.util.concurrent.*;

/**
 * @ClassName: ManyThread
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2019/1/5 10:31
 * @Version: 1.0
 */
public class ManyThread {
    private static LinkedBlockingQueue<String> deque = new LinkedBlockingQueue<>();

    private static BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(20000);

    public static void main(String[] args) throws InterruptedException {
        //要推送的用户总数
        int count = 1000000;
        // 初始化1000000条数据
        addmsgToQueue(count);

        ThreadPoolExecutor executors = new ThreadPoolExecutor(5, 6, 60000, TimeUnit.SECONDS, workQueue);
        long start = System.currentTimeMillis();
        //初始每个线程处理的用户数量
        final int eveLength = 2000;
        //计算处理所有用户需要的线程数量
        int eveBlocks = count / eveLength + (count % eveLength != 0 ? 1 : 0);
        //线程计数器
        CountDownLatch doneSignal = new CountDownLatch(eveBlocks);

        //开启线程处理
        int doneCount = 0;
        for (int page = 0; page < eveBlocks; page++) { /* blocks太大可以再细分重新调度 */
            MessageSendThread ms = new MessageSendThread(page + 1, eveLength, doneSignal);
            executors.execute(ms);
            //logger.info("start thread =>{}",page+1);
            doneCount++;
        }
        doneSignal.await();//等待所有计数器线程执行完
        long endTime = System.currentTimeMillis();
        System.out.println("多线程耗时： " + (endTime - start));
        executors.shutdown();

    }

    private static void sendMsg(Integer currentIndex, Integer rows) {
        for (int i = 0; i < rows; i++){
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("推送新消息:" + (i + (currentIndex - 1)*rows));
        }
    }

    private static void addmsgToQueue(int count) {
        for (int i = 0; i < count; i++) {
            deque.add("推送新消息：" + i);
        }
    }


    static class MessageSendThread implements Runnable {

        private Integer currentIndex;//当前索引
        private Integer rows;//处理数据条数
        private CountDownLatch doneSignal;//处理线程条数

        public MessageSendThread(Integer currentIndex, Integer rows, CountDownLatch doneSignal) {
            this.currentIndex = currentIndex;
            this.rows = rows;
            this.doneSignal = doneSignal;
        }


        @Override
        public void run() {
            try {
                sendMsg(currentIndex,rows);
            } catch (Exception e) {
            } finally {
                doneSignal.countDown();//工人完成工作，计数器减一
            }
        }
    }
    //多线程耗时： 354010
}
