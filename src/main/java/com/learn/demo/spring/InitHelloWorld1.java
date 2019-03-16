package com.learn.demo.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @ClassName: InitHelloWorld1
 * @Description: spring生命周期
 * @Author: 尚先生
 * @CreateDate: 2019/3/16 15:45
 * @Version: 1.0
 */
@Component
public class InitHelloWorld1 implements BeanPostProcessor, Ordered {
  @Override
  public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
    System.err.println("BeanPostProcessor1.postProcessBeforeInitialization:" + s);
    return o;
  }      
  @Override
  public Object postProcessAfterInitialization(Object o, String s) throws BeansException{
    System.err.println("BeanPostProcessor1.postProcessAfterInitialization:" + s);
    return o;
  }      
  @Override
  public int getOrder(){
    return 10;
  }
}