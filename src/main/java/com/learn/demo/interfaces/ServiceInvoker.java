package com.learn.demo.interfaces;

import java.util.function.Function;

public interface ServiceInvoker<T>{
        <R> R invoke(Function<T, R> func);
    }