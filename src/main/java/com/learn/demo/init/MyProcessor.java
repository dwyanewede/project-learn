package com.learn.demo.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName: BeanPostProcessor 初始化
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2019/1/7 12:59
 * @Version: 1.0
 */
//@CustomizeComponent
public class MyProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("myBean".equals(beanName)){
            System.out.println("i love you...........");
        }
        System.out.println("Myprocessor....................");
        return bean;
    }
}
