package com.learn.demo.java.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName: Interceptor
 * @Description: 拦截器实现类
 * @Author: 尚先生
 * @CreateDate: 2019/6/17 15:12
 * @Version: 1.0
 */
@Component
@Aspect
public class Interceptor {

//    @Pointcut("execution(* com.learn.demo.java.proxy.BusiServiceImpl.buyPhone(..))")
//    public void buyPhone() throws Throwable {
//    }
//
//    @Pointcut("execution(* com.learn.demo.java.proxy.BusiServiceImpl.buyComputer(..))")
//    public void buyComputer() throws Throwable {
//    }
//
//    @Around("buyPhone()")
//    public void buyPhoneMethod(ProceedingJoinPoint pjp) throws Throwable {
//
//        System.err.println("method buyPhone start time:" + System.currentTimeMillis());
//
//        Object re = pjp.proceed();
//
//        System.err.println("method buyPhone end time:" + System.currentTimeMillis() + "  " + re);
//
//    }
//
//    @Around("buyComputer()")
//    public void buyComputerMethod(ProceedingJoinPoint pjp) throws Throwable {
//
//        System.err.println("method buyComputer start time:" + System.currentTimeMillis());
//
//        Object re = pjp.proceed();
//
//        System.err.println("method buyComputer end time:" + System.currentTimeMillis() + "  " + re);
//
//    }


//    @Pointcut("execution(* com.learn.demo.java.proxy.BusiServiceImpl.*(..))")
//    public void buy(){
//        System.out.println("------------------------------------");
//    }
//    @Around("buy()")
//    public void around(ProceedingJoinPoint point) {
//        try {
//            //通过获取 Intercept 注解
//            Method proxyMethod = ((MethodSignature) point.getSignature()).getMethod();
//            Method targetMethod = point.getTarget().getClass().getMethod(proxyMethod.getName(), proxyMethod.getParameterTypes());
//            Intercept intercept = targetMethod.getAnnotation(Intercept.class);
//            String methodName = targetMethod.getName();
//            //处理注解逻辑
//            String value = intercept.value();
//            System.out.println("----------- " + methodName + " 获取拦截信息------------" + value);
//            point.proceed();
//        } catch (Throwable e) {
//            System.out.println("执行异常"+ e.getMessage());
//        }
//    }


    @Pointcut(value = "@annotation(com.learn.demo.java.proxy.Intercept)")
    public void buySomething() {
        System.out.println("===========自定义切入点===============");
    }

//    @Before("buySomething()")
//    public void doBefore() {
//        System.out.println("=====buySomething前置=====");
//
//    }

    @Around("buySomething()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        try {
            //通过获取 Intercept 注解
            Method proxyMethod = ((MethodSignature) point.getSignature()).getMethod();
            Method targetMethod = point.getTarget().getClass().getMethod(proxyMethod.getName(), proxyMethod.getParameterTypes());
            Intercept intercept = targetMethod.getAnnotation(Intercept.class);
            String methodName = targetMethod.getName();
            //处理注解逻辑
            String value = intercept.value();
            System.err.println("=========== " + methodName + " 获取前置拦截信息 ===========" + value);
            return point.proceed();
        } catch (Throwable e) {
            System.out.println("执行异常"+ e.getMessage());
        }finally {
            System.err.println("=========== " + " 后置处理结果返回 ===========");
        }
        return "执行异常，请查看详细日志信息";
    }
}
