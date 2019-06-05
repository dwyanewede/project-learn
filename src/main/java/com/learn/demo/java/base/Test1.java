package com.learn.demo.java.base;

/**
 * @ClassName: Test1
 * @Description: 数据引用类型实例测试
 * @Author: 尚先生
 * @CreateDate: 2019/6/5 15:40
 * @Version: 1.0
 */
public class Test1 {

//    怎么理解而引用类型如果不修改原指针时赋值将改变：
//    如果  setVale(List  list) 中 list集合，如果 对 list 集合重新赋予地址 eg. 方法体｛ list=new list()｝,
// 此时原值不变；如果对list 集合里面的数据赋值，则值会改变 . eg.方法体 ｛list.add(a)｝,打印list 值会改变;

//    思考原因：
//    因为方法体会建立临时表（局部变量表）会建立新的堆栈，对直接引用不处理，所以 8大基本类型和string还有引用类型，
// 直接处理不改变其值；但是临时表会到引用类型的指针，对指针的值重新赋值是可以的，所以可以改变list集合里面的数据。

    public static void main(String[] args) {
        String S="ASDFASDF";
        setValue(S);
        System.out.println(S);
        int i=466546;
        setValueInt(i);
        System.out.println(i);

        //发现 基本数据类型 和 String 经过方法处理后 值不变化  String本质是final类型char数组
        // 而数组 和 list 集合 经过 方法处理后  期 里面的值会发生变化
        //说明 基本数据类型 和String 是值拷贝，而 数组和list 集合处理的是引用
        StringBuilder str = new StringBuilder("546");
        setValue(str);
        System.out.println(str.toString()); //输出空字符串
        setValue2(str);
        System.out.println(str.toString()); //输出sss
    }

    public static void setValue(StringBuilder str){
        str = new StringBuilder("sss111");
    }

    public static void setValue2(StringBuilder str){
        str.append("sss222");
    }
    public static void setValue(String ss){
        ss="adfasdfa";
    }
    public static void setValueInt(int ss){
        ss=8888;
    }
}
