package com.learn.demo.design.pattern.handler;

/**
 * @ClassName: ZhangSan
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/19 18:51
 * @Version: 1.0
 */
public class ZhangSan extends Person{

    public static void main(String[] args) {
        ZhangSan person = new ZhangSan();
        person.setId(1);
        person.setName("小朋友");
        System.out.println(person.toString());

    }
    public void setName(String name) {
        super.setName(name);
    }
}
