package com.learn.demo.java.base;

/**
 * @ClassName: InterFaceTest
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2019/1/13 20:01
 * @Version: 1.0
 */
public interface InterFaceTest {
    public static void method1(){
        System.out.println("-------接口默认实现1-------");
    }
    public default void method2(){
        System.out.println("-------接口默认实现2-------");
    }
}
