package com.learn.demo.spring.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @ClassName: LifeCycleConfiguration
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2019/5/8 16:16
 * @Version: 1.0
 */
@Configuration
public class LifeCycleConfiguration {

    @Bean
    public Person person(){
        Person person = new Person();
        person.setName("sxs");
        person.setPhone(17621061573L);
        person.setAddress("beijing");
        return person;
    }

    @Bean
    public MyBeanPostProcessor beanPostProcessor(){
        return new MyBeanPostProcessor();
    }

    @Bean
    public MyBeanFactoryPostProcessor beanFactoryPostProcessor(){
        return new MyBeanFactoryPostProcessor();
    }

    @Bean
    public MyInstantiationAwareBeanPostProcessor instantiationAwareBeanPostProcessor(){
        return new MyInstantiationAwareBeanPostProcessor();
    }

}
