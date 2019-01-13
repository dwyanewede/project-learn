package com.learn.demo.java.base;

/**
 * @ClassName: Finally
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2019/1/13 19:24
 * @Version: 1.0
 */
public class Finally {

    //final修饰一个成员变量（属性），必须要显示初始化。这里有两种初始化方式，一种是在变量声明的时候初始化；
    // 第二种方法是在声明变量的时候不赋初值，但是要在这个变量所在的类的所有的构造函数中对这个变量赋初值。
    private final String str;

    public Finally(String str) {
        this.str = null;
    }

    public static void main(String[] args) {
        int res1 = getResult();
        System.out.println("========" + res1 + " =========");
    }

    public static int getResult() {
        //finally中的代码不一定执行
        //        int s = 1 / 0;
        try {
            int i = 1;
//            if (1 == i){
//                return 0;
//            }
//            i = i / 0;
            // try代码执行finally中的代码不一定执行
//            System.exit(0);
            return 3;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return 4;
        }
    }

    //finalize()是在java.lang.Object里定义的，也就是说每一个对象都有这么个方法。这个方法在gc启动，
    // 该对象被回收的时候被调用。其实gc可以回收大部分的对象（凡是new出来的对象，gc都能搞定，
    // 一般情况下我们又不会用new以外的方式去创建对象），所以一般是不需要程序员去实现finalize的。
    // 使用finalize还需要注意一个事，调用super.finalize();
}
