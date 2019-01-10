package com.learn.demo.file;

import java.io.File;

/**
 * @ClassName: FileDemo
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/11 11:50
 * @Version: 1.0
 */
public class FileDemo {

    // 输出结果
    //D:\MyWorkSpace\gupao-project\demo-tomcat

    //------------------

    //D:\MyWorkSpace\gupao-project\demo-tomcat
    public static void main(String[] args) {
        File file = new File("");
        System.out.println(file.getAbsolutePath());
        System.out.println("------------------");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("java.vm.name"));
    }
}
