package com.learn.demo.concurrent.sxs;

public class RunnableJob {
   public static void main(String[] args) throws InterruptedException {
	   Worker runnableJob = new Worker();
       Thread t1 = new Thread(runnableJob, "老二");
       Thread t2 = new Thread(runnableJob, "老大");
       Thread t3 = new Thread(runnableJob, "老爸");
       t1.start();  
       t1.join();  
       t2.start();  
       t2.join();  
       t3.start();  
       t3.join();  
       System.out.println("主线程执行完毕----");  
  }
}

class Worker implements Runnable{
	public void run() {
        Thread thread = Thread.currentThread();
        try {
            Thread.sleep(5000);
            System.out.println(thread.getName()+"吃完了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}