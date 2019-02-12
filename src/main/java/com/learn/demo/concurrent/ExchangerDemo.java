package com.learn.demo.concurrent;

import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ExchangerDemo {
	 public static void main(String[] args) {  
	        Exchanger<Integer> exchanger = new Exchanger<>();
	        new Girl(exchanger).start();  
	        new Man(exchanger).start();  
	    }  
}

/**
 * 男人
 * @author admin
 */
class Man extends Thread {  
    Exchanger<Integer> exchanger = null;  
    public Man(Exchanger<Integer> exchanger) {  
        super();  
        this.exchanger = exchanger;  
    }  
    @Override  
    public void run() {  
        Random rand = new Random();
        int money = 0;
        for(int i=0;i<4;i++){
        	money+=100000;//年薪在10万以内
        	try {
				exchanger.exchange(money);//存钱
//                TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }  
}

/**
 * 女人
 */
class Girl extends Thread {  
    Exchanger<Integer> exchanger = null;  
    int money = 0;
    public Girl(Exchanger<Integer> exchanger) {  
        super();  
        this.exchanger = exchanger;  
    }  
    @Override  
    public void run() {  
    	for(int i=0;i<4;i++){
    		try {
				money = exchanger.exchange(money,2,TimeUnit.SECONDS) ;
				System.out.println(money>300000?"亲爱的"+money+"万我们可以结婚了":money+"块这么少,"+"臭屌丝活该单身,还不去赚钱娶老婆");
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    }  
}