package com.learn.demo.design.pattern;

import java.util.Optional;

/**
 * @ClassName: OptionalDemo
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/18 16:38
 * @Version: 1.0
 */
public class OptionalDemo {

    public static void main(String[] args) {

        Optional<String> optional = Optional.of("hello ");

        System.out.println(
                optional.map(value -> value + "world ")
                .map(value -> value + "2018")
        );
    }
}
