package com.learn.demo.java.base.event;

/**
 * @ClassName: Event
 * @Description: 事件监听源
 * @Author: 尚先生
 * @CreateDate: 2019/2/25 9:31
 * @Version: 1.0
 */
public class Event {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                '}';
    }
}
