package com.learn.demo.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: MainApp
 * @Description: spring生命周期启动类
 * @Author: 尚先生
 * @CreateDate: 2019/3/16 15:55
 * @Version: 1.0
 */
public class MainApp{
  public static void main(String... args){
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(HelloConfiguration.class);
    context.refresh();
    Hello hello = (Hello) context.getBean("hello");
    hello.hello();
    context.close();
  }
}