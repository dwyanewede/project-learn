package com.learn.demo.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	public static void main(String[] args) {  
        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(2);
        final int count = 5;  
        for (int i = 0; i < count; i++) {  
            Runnable runnable = new Runnable() {  
                public void run() {  
                    try {  
                        semaphore.acquire();
                        System.out.println("线程:" + Thread.currentThread().getName()+"开始下载");  
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    } finally {  
                        System.out.println("线程:" + Thread.currentThread().getName() + "下载完毕");  
                        semaphore.release();  
                    }  
                }  
            };  
            service.execute(runnable);//放在线程池中去维护
        }  
        service.shutdown();  
    }  
}