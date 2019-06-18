package com.learn.demo.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: ReflectionHandler
 * @Description: 自定义处理handler
 * @Author: 尚先生
 * @CreateDate: 2019/6/17 14:54
 * @Version: 1.0
 */
public class ReflectionHandler implements InvocationHandler {

    private Object target;

    public ReflectionHandler(Object target) {
        this.target = target;
    }

    public <T> T getProxy(){
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target,args);
    }
}
