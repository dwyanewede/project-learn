package com.learn.demo.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName: PropertiesDemo
 * @Description: 绝对路径读取配置文件
 * @Author: 尚先生
 * @CreateDate: 2018/12/11 12:35
 * @Version: 1.0
 */
public class PropertiesDemo {

    public static void main(String[] args) throws IOException {

//        String basePath = System.getProperty("user.dir");
//        String basePath = System.getProperty("java.class.path");

//        String path = basePath + "\\" + "application.properties";

        System.out.println("--------------------方法一-------------------");
        File propertiesFile = new File("D:\\MyWorkSpace\\gupao-project\\demo-tomcat\\src\\main\\resources\\application.properties");
        Properties properties1 = new Properties();
        properties1.load(new FileInputStream(propertiesFile));
        System.out.println("appName1:  " + properties1.get("spring.application.name"));


        System.out.println("--------------------方法二-------------------");

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("application.properties");
        Properties properties2 = new Properties();
        properties2.load(stream);
        System.out.println("appName2:  " + properties1.get("spring.application.name"));
    }
}
