package com.learn.demo.java.proxy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName: AspectJConfig
 * @Description: 开启Spring对AspectJ的支持
 * @Author: 尚先生
 * @CreateDate: 2019/6/17 18:39
 * @Version: 1.0
 */
@Configuration
@ComponentScan("com.learn.demo.java.proxy")
@EnableAspectJAutoProxy
public class AspectJConfiguration {
}