package com.learn.demo.test.interfaces;

import java.util.function.Function;

public interface ServiceInvoker<T>{
        <R> R invoke(Function<T, R> func);
    }