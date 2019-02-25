package com.learn.demo.java.base.event;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName: EventSourceDemo
 * @Description: 自定义事件源
 * @Author: 尚先生
 * @CreateDate: 2019/2/25 9:11
 * @Version: 1.0
 */
public class EventSourceDemo {

    private LinkedBlockingQueue<EventListenerDemo> queue = new LinkedBlockingQueue<>();

    public EventSourceDemo() {
        super();
    }

    public void addMyEventListener(EventListenerDemo eventListener) {
        queue.offer(eventListener);
    }

    public void deleteMyEventListener(EventListenerDemo eventListener) {
        queue.remove(eventListener);
    }

    public void notifyMyEvent(EventObjectDemo eventObject) {
        Iterator<EventListenerDemo> iterator = queue.iterator();
        while (iterator.hasNext()) {
            //在类中实例化自定义的监听器对象,并调用监听器方法
            iterator.next().execute(eventObject);
        }
    }
}
