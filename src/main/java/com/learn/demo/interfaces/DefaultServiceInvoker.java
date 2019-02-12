package com.learn.demo.interfaces;

import java.util.function.Function;

//@Component(value="serviceInvoker")
public class DefaultServiceInvoker<T> implements ServiceInvoker{

        private final T service;

        public DefaultServiceInvoker(T service) {
            this.service = service;
        }

        @Override
        public Object invoke(Function func) {
            System.out.println("----function----");
            return func.apply(service);
        }
    }