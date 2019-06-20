package com.learn.demo.java.classloader;

/**
 * @ClassName: Father
 * @Description: 父类对象
 * @Author: 尚先生
 * @CreateDate: 2019/6/20 9:35
 * @Version: 1.0
 */
public class Father {

    public static int fi = 300;

    public  int fj = 1;

    static {
        fi ++;
        System.out.println("父类静态代码块 fi: " + fi);
    }


    public Father() {
        fj++;
        System.out.println("父类构造函数 fj: " + fj);
    }


    {
        fi ++;
        System.out.println("父类方法块 fi: " + fi);

        fj++;
        System.out.println("父类方法块 fj: " + fj);
    }


}
