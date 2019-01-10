package com.learn.demo.design.pattern;

import java.io.Serializable;

/**
 * @ClassName: MarkInterFaceDemo
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/17 20:20
 * @Version: 1.0
 */
public class MarkInterFaceDemo {

    public static void main(String[] args) {
        // 序列化
        // Hibernate Session
        // JPA Entity 实现Serializable
        // （PK）Primary Key 也需要实现序列化
        // （PK）数值类型Long Integer Short Double Float
        // （PK）字符类型（String）
        Serializable value = new Long(1L);
        value = new Integer(1);
        value = new Short((short)1);
//        value = new Double(1);
//        value = new String("123");

        save(value);
    }
    public  static void save(Serializable value){
        System.out.println("save 保存结果： " + value);
    }
}
