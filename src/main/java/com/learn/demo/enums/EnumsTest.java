package com.learn.demo.enums;

/**
 * @ClassName: EnumsTest
 * @Description: 枚举示例测试
 * @Author: 尚先生
 * @CreateDate: 2019/3/22 22:55
 * @Version: 1.0
 */
public class EnumsTest {

    public static void main(String[] args) {

        String instance = EnumsDemo.INSTANCE.getInstance();
        System.out.println("instance " + instance);
    }

}
