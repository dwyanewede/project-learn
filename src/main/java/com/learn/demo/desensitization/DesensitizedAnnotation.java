package com.learn.demo.desensitization;

import java.lang.annotation.*;

/**
 * @ClassName: DesensitizedAnnotation
 * @Description: 注解类
 * @Author: 尚先生
 * @CreateDate: 2019/1/24 17:42
 * @Version: 1.0
 */
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DesensitizedAnnotation {
    /*脱敏数据类型(规则)*/
    TypeEnum type();
    /*判断注解是否生效，暂时没有用到*/
    String isEffictiveMethod() default "";

}
