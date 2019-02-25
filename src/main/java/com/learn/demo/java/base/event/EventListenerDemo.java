package com.learn.demo.java.base.event;

import java.util.EventListener;

/**
 * @ClassName: EventListenerDemo
 * @Description: 自定义监听器
 * @Author: 尚先生
 * @CreateDate: 2019/2/25 8:53
 * @Version: 1.0
 */
public class EventListenerDemo implements EventListener {


    /**
     * 执行监听器
     * @param eventObject
     */
    public void execute(EventObjectDemo eventObject){
        System.err.println(eventObject.getSource());
    }
}
