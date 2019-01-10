package com.learn.demo.design.pattern.handler;

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName: ObserversDemo
 * @Description: 观察者模式
 * @Author: 尚先生
 * @CreateDate: 2018/12/19 14:20
 * @Version: 1.0
 */
public class ObserversDemo {

    // JDK存在观察者模式
    // Observable 是维护多个有序的Observer的集合，Subject、Publisher
    // Observer = Consumer = Subscriber


    public static void main(String[] args) {

        MyObservable observable = new MyObservable();

        // 所有的 Observer 在 Observable 中在Vector（线程安全的List）中存储
        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("reciver1: " + arg);
            }
        });
        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("reciver2: " + arg);
            }
        });

        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("reciver3: " + arg);
            }
        });

        // 改变
        observable.setChanged();
        // 通知 通知的顺序是倒叙
        observable.notifyObservers("hello world");
    }


    // 由于 Observable 中的 setChanged方法是受保护的，所以要子类继承才能修改 changed的值
    static class MyObservable extends Observable{
        public synchronized void setChanged() {
           super.setChanged();
        }
    }

}
