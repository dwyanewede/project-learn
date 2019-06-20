package com.learn.demo.java.classloader;

/**
 * @ClassName: Son
 * @Description: 子类对象
 * @Author: 尚先生
 * @CreateDate: 2019/6/20 9:35
 * @Version: 1.0
 */
public class Son extends Father {


    // 注释放开后，由于在代码编译的时候将变量信息加载，故子类会使用自身的变量
    // public static int fi = 100;
    // public  int fj = 11;

    static {
        fi ++;
        System.out.println("子类静态代码块 zi: " + fi);
    }

    public Son() {
        fj++;
        System.out.println("子类构造函数 zj: " + fj);
    }

    {
        fi ++;
        System.out.println("子类方法块 zi: " + fi);

        fj++;
        System.out.println("子类方法块 zj: " + fj);
    }

    public static void main(String[] args) {
        Son son1 = new Son();
        Son son2 = new Son();
    }
}

//         创建单一对象
//        父类静态代码块 fi: 301
//        子类静态代码块 fi: 302
//        父类方法块 fi: 303
//        父类方法块 fj: 2
//        父类构造函数 fj: 3
//        子类方法块 fi: 304
//        子类方法块 fj: 4
//        子类构造函数 fj: 5


//         创建多个对象
//        父类静态代码块 fi: 301
//        子类静态代码块 zi: 302
//        父类方法块 fi: 303
//        父类方法块 fj: 2
//        父类构造函数 fj: 3
//        子类方法块 zi: 304
//        子类方法块 zj: 4
//        子类构造函数 zj: 5
//        父类方法块 fi: 305
//        父类方法块 fj: 2
//        父类构造函数 fj: 3
//        子类方法块 zi: 306
//        子类方法块 zj: 4
//        子类构造函数 zj: 5