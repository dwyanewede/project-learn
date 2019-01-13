package com.learn.demo.aop.transaction;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 自定义代理，JDK动态代理
 *
 */

public class MyCustomProxy implements InvocationHandler {
 
   private Object target;

   public MyCustomProxy(Object target) {
      this.target = target;
   }
 
   @Override
   public Object invoke(Object proxy, Method method, Object[] args)
         throws Throwable {
      if (isNeed(method)) {//只有被@MyTransaction注解标识的方法才执行开启事务操作。
         beginTransaction(proxy);
      }
      Object res = method.invoke(target, args);
     
      if (isNeed(method)) {
         endTransaction();
      }
      return res;
   }
  
   /**
    *模拟开启事务，假如通用点，就很类似AOP中的 Before advice
    */
   private void beginTransaction(Object o){
      System.out.println("-----开始事务--------");
   }
  
   /**
    *模拟结束事务，假如通用点，就很类似AOP中的 After advice
    */
   private void endTransaction(){
      System.out.println("-----结束事务--------");
   }
  
   /**
    * 这个实现也可以更加的通用，基于不同的对象不同方法不同的规则
    */
   private boolean isNeed(Method method) {
     /* if (method.getAnnotation(MyTransaction.class) != null) {
         return true;
      }
     
      return false;
   }*/
      return true;
   }
}