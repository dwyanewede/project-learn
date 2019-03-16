package com.learn.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: HelloConfiguration
 * @Description: spring生命周期配置类
 * @Author: 尚先生
 * @CreateDate: 2019/3/16 15:48
 * @Version: 1.0
 */
@Configuration
public class HelloConfiguration {

    @Bean
    public Hello hello(){
        Hello hello1 = new Hello();
        hello1.setMessage("妮儿");
        return hello1;
    }

    @Bean
    public InitHelloWorld1 initHelloWorld(){
        return new InitHelloWorld1();
    }

    @Bean
    public InitHelloWorld2 initHelloWorld2(){
        return new InitHelloWorld2();
    }
}
