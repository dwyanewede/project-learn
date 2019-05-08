package com.learn.demo.java.base;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ClassLoader;

/**
 * @ClassName: MyClassLoader
 * @Description: 自定义实现 ClassLoader
 * @Author: 尚先生
 * @CreateDate: 2019/3/18 20:15
 * @Version: 1.0
 */
class MyClassLoader extends ClassLoader{

    public Class<?> loadClass(String name) throws ClassNotFoundException {
        String fileName = name.substring(name.lastIndexOf(".")+1) + ".class";
        InputStream is = getClass().getResourceAsStream(fileName);
        if (is == null) {
            return super.loadClass(name);
        }
        try {
            byte[] b = new byte[is.available()];
            is.read(b);
            return defineClass(name, b, 0, b.length);
        } catch (IOException e) {
            throw new ClassNotFoundException();
        }
    }

}

public class MyClassLoaderTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        ClassLoader classLoader = new MyClassLoader();
        Class<?> clazz = classLoader.loadClass("com.learn.demo.java.base.MyClassLoaderTest");
        Object entity = clazz.newInstance();
        System.out.println(entity instanceof MyClassLoaderTest);
    }

}
