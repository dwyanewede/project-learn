package com.learn.demo.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

public class ForkJoinDemo2 {
    public static void main(String[] args) {
        /** 4核 **/
        System.out.printf("当前公用 ForkJoin 线程池 并行数：%d\n",ForkJoinPool.commonPool().getParallelism());
        System.out.printf("当前CPU 处理器数：%d\n",Runtime.getRuntime().availableProcessors());
        // 创建线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        AtomicInteger atomicInteger = new AtomicInteger();
        // 创建task实现
        RecursiveAction recursiveAction = new Task(integers, atomicInteger);
        //提交并执行
        forkJoinPool.invoke(recursiveAction);
        // 关闭任务
        forkJoinPool.shutdown();
        System.out.println("运行结果: " + atomicInteger);

    }

    private static class Task extends RecursiveAction {

        private final List<Integer> integers;

        private final AtomicInteger atomicInteger;

        Task(List<Integer> integers, AtomicInteger atomicInteger) {
            this.integers = integers;
            this.atomicInteger = atomicInteger;
        }

        @Override
        protected void compute() {
            System.out.println("线程名称：" + Thread.currentThread().getName());
            // 组装执行参数
            int size = integers.size();
            if (size >1){
                int part = size / 2;
                List<Integer> leftPart = integers.subList(0, part);
                Task task1 = new Task(leftPart, atomicInteger);
                List<Integer> rightPart = integers.subList(part, size);
                Task task2 = new Task(rightPart, atomicInteger);
                // fork/join  实现串行化
                invokeAll(task1,task2);
            }else {
                if (size == 0){
                    return;
                }
                Integer num = integers.get(0);
                //累加
                atomicInteger.addAndGet(num);
            }
        }
    }
}