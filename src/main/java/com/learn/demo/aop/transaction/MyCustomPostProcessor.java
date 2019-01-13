package com.learn.demo.aop.transaction;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * 注意打印的文字，观察其生命周期
 * 这里只对UserService创建代理
 *
 */
@Component
public class MyCustomPostProcessor implements BeanPostProcessor {
 
   @Override
   public Object postProcessAfterInitialization(Object arg0, String arg1)
         throws BeansException {
      if (arg0 instanceof UserService) {//为UserService创建代理，实现事务，如果这里的可以是基于某种规则，如@ASPECTJ的规则
         System.out
                .println(" i am postProcessAfterInitialization beanname :"
                      + arg1 + " BEAN type:" + arg0);
        
         System.out.println("创建代理，实现事务");
         //创建代理，这里可以通过一个代理工厂，根据不同的规则采用不同的InvokeHandler
         Object res = Proxy.newProxyInstance(getClass().getClassLoader(), arg0.getClass().getInterfaces(), new MyCustomProxy(arg0));
         return res;
      }
      return arg0;
   }
 
   @Override
   public Object postProcessBeforeInitialization(Object arg0, String arg1)
         throws BeansException {
      if (arg0 instanceof UserService) {
         System.out
                .println(" i am postProcessBeforeInitialization beanname :"
                      + arg1 + " BEAN type:" + arg0);
      }
      return arg0;
   }
 
}