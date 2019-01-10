package com.learn.demo.thread.sendMsg;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName: SingleThread
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2019/1/5 10:19
 * @Version: 1.0
 */
public class SingleThread {

    private static LinkedBlockingQueue<String> deque = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        // 初始化1000000条数据
        addmsgToQueue();
        // 发送新消息
        sendMsg();

    }

    private static void sendMsg() {
        long timeMillis = System.currentTimeMillis();
        System.out.println("起始时间：" + timeMillis);
        deque.forEach(consumer -> {
//            try {
//                TimeUnit.MILLISECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(consumer);});
        System.out.println("单线程耗时：" + (System.currentTimeMillis() - timeMillis));
    }

    private static void addmsgToQueue() {
        for (int i = 0; i < 1000000; i++){
            deque.add("推送新消息：" + i);
        }
    }
    // 单线程耗时：1869234
}
