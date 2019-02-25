package com.learn.demo.java.base.event;

import java.util.EventObject;

/**
 * @ClassName: EventObjectDemo
 * @Description: 自定义事件
 * @Author: 尚先生
 * @CreateDate: 2019/2/25 8:53
 * @Version: 1.0
 */
public class EventObjectDemo extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public EventObjectDemo(Object source) {
        super(source);
    }
}
