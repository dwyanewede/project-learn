package com.learn.demo.java.base.event;

public class EventTest {

    public static void main(String args[]) {
        // 创建 eventListener
        EventListenerDemo eventListener = new EventListenerDemo();
        // 创建 eventSource
        EventSourceDemo eventSource = new EventSourceDemo();
        // 添加 eventListener
        eventSource.addMyEventListener(eventListener);
        // 创建事件源
        Event event = new Event();
        event.setName("event");
        EventObjectDemo eventObjectDemo = new EventObjectDemo(event);
        // 事件通知
        eventSource.notifyMyEvent(eventObjectDemo);
    }
}