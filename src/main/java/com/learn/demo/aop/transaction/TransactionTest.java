package com.learn.demo.aop.transaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: TransactionTest
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2019/1/12 23:54
 * @Version: 1.0
 */
public class TransactionTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ComponentScan.class);
        context.refresh();
        UserService userService0 = context.getBean("userService", UserService.class);
        System.out.println(userService0.sayHello("尚先生"));
    }
}
