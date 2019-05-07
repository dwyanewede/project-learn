package com.learn.demo.java.base;
import java.lang.ClassLoader;

/**
 * ClassLoaderTest of SystemClassLoader
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("com.learn.demo.java.base.ClassLoaderTest");
        Object entity = clazz.newInstance();
        System.out.println(entity instanceof ClassLoaderTest);
    }
}