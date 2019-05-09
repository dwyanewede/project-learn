package com.learn.demo.concurrent.xiaomage.thread;

import java.util.concurrent.*;

public class ThreadPoolExecutorExceptionQuestion {

    public static void main(String[] args) throws InterruptedException {

//        ExecutorService executorService = Executors.newFixedThreadPool(2);

        ThreadPoolExecutor executorService = new ThreadPoolExecutor(
                1,
                1,
                0,
                TimeUnit.MILLISECONDS,
                // TODO 1. 设置队列长度可使用默认的拒绝策略，否则会无限扩展
                // Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task com.learn.demo.concurrent.xiaomage.thread
                new LinkedBlockingQueue<>(2)
        )
                // TODO 2. 实现回调
//        {
//
//            /**
//             * 通过覆盖 {@link ThreadPoolExecutor#afterExecute(Runnable, Throwable)} 达到获取异常的信息
//             * @param r
//             * @param t
//             */
//            @Override
//            protected void afterExecute(Runnable r, Throwable t) {
//                System.out.printf("线程[%s] 遇到了异常，详细信息：%s\n",
//                        Thread.currentThread().getName(),
//                        t.getMessage());
//            }
//
//        }
 ;

        for(int i =0; i < 10; i++){
            executorService.execute(() -> {
                // TODO 2. 实现回调
                // throw new RuntimeException("数据达到阈值");
            });
        }

        // 等待一秒钟，确保提交的任务完成
        executorService.awaitTermination(1, TimeUnit.SECONDS);

        // 关闭线程池
        executorService.shutdown();

    }
}
