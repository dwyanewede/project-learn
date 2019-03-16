package com.learn.demo.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName: Hello1
 * @Description: spring生命周期
 * @Author: 尚先生
 * @CreateDate: 2019/3/16 15:45
 * @Version: 1.0
 */
@Component
public class Hello implements InitializingBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware, DisposableBean, ApplicationListener<ContextRefreshedEvent> {
    private String message;

    public void setMessage(String message){
        System.err.println("Hello1 setMessage");
        this.message = message;
    }
    public Hello(){
        System.err.println("Hello1 构造器");
    }
    public void hello(){
        System.err.println("Hello1 i love：" + message);
    }
    public void init_method(){
        System.err.println("Hello1 init-method ");
    }
    @PostConstruct
    public void postConstruct(){
        System.err.println("Hello1 @PostConstruct");
    }
    @Override
    public void afterPropertiesSet() throws Exception{
        System.err.println("Hello1 InitializingBean.afterPropertiesSet");
    }
    @Override
    public void setBeanName(String s){
        System.err.println("Hello1 setBeanName " + s);
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.err.println("Hello1 setBeanFactory " );
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
        System.err.println("Hello1 setApplicationContext " );
    }
    @Override
    public void destroy() throws Exception{
        System.err.println("Hello1 DisposableBean.destroy " );
    }
    public void destroy_method() throws Exception{
        System.err.println("Hello1 destroy-method " );
    }
    @PreDestroy
    public void preDestroy() throws Exception{
        System.err.println("Hello1 @PreDestroy " );
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Hello1 @ContextRefreshedEvent " );
    }
}
