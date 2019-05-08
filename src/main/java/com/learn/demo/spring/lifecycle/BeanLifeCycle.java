package com.learn.demo.spring.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class BeanLifeCycle {

    public static void main(String[] args) {

        System.out.println("现在开始初始化容器");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        System.out.println("容器初始化成功");    
        //得到Preson，并使用
        context.register(LifeCycleConfiguration.class);
        context.refresh();
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
        System.out.println("现在开始关闭容器！");
        context.registerShutdownHook();
    }
}
