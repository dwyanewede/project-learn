package com.learn.demo.design.pattern;

import java.io.*;

/**
 * @ClassName: DesignDemo
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/19 8:55
 * @Version: 1.0
 */
public class DesignDemo {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

    }

    private static void doReader(Reader reader) {

    }

    //适配器模式 被适配接口与适配接口没有关系
    public static void test1() throws FileNotFoundException, UnsupportedEncodingException{
        // 字节流，目前拥有的实例
        InputStream in = new FileInputStream("test.txt");
        // 需要的对象
        // Instream -> Reader
        Reader reader = new InputStreamReader(in, "UTF-8");
        doReader(reader);
    }

    //装饰器模式 被适配接口与适配接口有关系，动态添加或者是覆盖
    public static void test2() throws FileNotFoundException{
        // 字节流，目前拥有的实例
        InputStream in = new FileInputStream("test.txt");
        // 装饰着
        FilterInputStream filterInputStream = new DataInputStream(in);
    }

    // 享元模式
    public static void test3(){
        String value = new String("hello");//堆
        String newValue = value.intern(); // 常量池
    }
}
