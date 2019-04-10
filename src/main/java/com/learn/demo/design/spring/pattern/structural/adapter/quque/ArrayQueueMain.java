package com.learn.demo.design.spring.pattern.structural.adapter.quque;


/**
 * @ClassName: ArrayQueueMain
 * @Description: 测试类
 * @Author: 尚先生
 * @CreateDate: 2019/4/10 11:40
 * @Version: 1.0
 */
public class ArrayQueueMain {

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>(6);

        try {
            for(int i = 0; i < 6; i++) {
                queue.add(i);
            }

            System.err.println(queue);

            for(int i = 0; i < 5; i++) {
                queue.remove();
                System.out.println(queue);
            }

        } catch(Exception e) {
            System.err.println(e);
        }

    }
}
