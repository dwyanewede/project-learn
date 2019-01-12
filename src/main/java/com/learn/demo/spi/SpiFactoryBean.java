package com.learn.demo.spi;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.FactoryBean;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class SpiFactoryBean<T> implements FactoryBean<T> {
    private Class<? extends ISpi> spiClz;

    private List<ISpi> list;

    public SpiFactoryBean(ApplicationContext applicationContext, Class<? extends ISpi> clz) {
        this.spiClz = clz;

        Map<String, ? extends ISpi> map = applicationContext.getBeansOfType(spiClz);
        list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingInt(ISpi::order));
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getObject() throws Exception {
        // jdk动态代理类生成
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                for (ISpi spi : list) {
                    if (spi.verify(args[0])) {
                        // 第一个参数作为条件选择
                        return method.invoke(spi, args);
                    }
                }

                throw new Exception("no spi server can execute! spiList: " + list);
            }
        };

        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{spiClz},
                invocationHandler);
    }

    @Override
    public Class<?> getObjectType() {
        return spiClz;
    }
}
