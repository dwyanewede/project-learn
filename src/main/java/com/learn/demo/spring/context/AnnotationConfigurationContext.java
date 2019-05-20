package com.learn.demo.spring.context;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;

/**
 * @ClassName: AnnotationConfigurationContext
 * @Description: web容器关闭，事件监听模拟实现
 * @Author: 尚先生
 * @CreateDate: 2019/5/20 14:44
 * @Version: 1.0
 */
public class AnnotationConfigurationContext {

    public static void main(String[] args) {

        // 创建 Annotation 驱动的 Spring 应用上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 EventConfiguration 到 Spring 应用上下文
        context.scan("com.learn.demo.spring.context");
        // 启动 Spring 应用上下文
        context.refresh();
        // AnnotationConfigApplicationContext 也是 ApplicationEventPublisher
        ApplicationEventPublisher publisher = context;
        // 发布一个 MyApplicationEvent
        publisher.publishEvent(new ContextClosedEvent(context));
    }
}
