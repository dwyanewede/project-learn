package com.learn.demo.java.base.reference;

/**
 * @ClassName: Test3
 * @Description: 数据引用类型实例测试
 * @Author: 尚先生
 * @CreateDate: 2019/6/5 15:23
 * @Version: 1.0
 */
public class Test3 {

    public static void setValue(StringBuilder str){
        str = new StringBuilder("sss");
    }

    public static void setValue2(StringBuilder str){
        str.append("sss");
    }

    private static void setValue3(PersonTest personTest) {
        personTest.setName("sxs");
        personTest.setAge(16);
    }

    public static void main(String[] args) {

        StringBuilder str = new StringBuilder();
        setValue(str);

        System.out.println(str.toString()); //输出空字符串

        setValue2(str);
        System.out.println(str.toString()); //输出sss

        PersonTest personTest = new PersonTest();
        setValue3(personTest);
        System.out.println(personTest);
    }
}
