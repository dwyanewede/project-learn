package com.learn.demo.java.base.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @ClassName: SpringEventTest
 * @Description: Spring事件监听
 * @Author: 尚先生
 * @CreateDate: 2019/3/1 8:36
 * @Version: 1.0
 */
public class SpringEventTest {

    public static void main(String[] args) {
        // 创建 Annotation 驱动的 Spring 应用上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 EventConfiguration 到 Spring 应用上下文
        context.register(EventConfiguration.class);
        // 启动 Spring 应用上下文
        context.refresh();
        // AnnotationConfigApplicationContext 也是 ApplicationEventPublisher
        ApplicationEventPublisher publisher = context;
        // 发布一个 MyApplicationEvent
        publisher.publishEvent(new MyApplicationEvent("Hello,World"));
    }

    private static class MyApplicationEvent extends ApplicationEvent {

        public MyApplicationEvent(String message) {
            super(message);
        }
    }

    @Configuration
    public static class EventConfiguration {

        /**
         * 监听MyApplicationEvent
         * @param event
         */
        @EventListener
        public void onEvent(MyApplicationEvent event) {
            System.out.println("监听事件 : " + event);
        }

    }

}