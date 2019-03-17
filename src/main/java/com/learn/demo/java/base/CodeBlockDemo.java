package com.learn.demo.java.base;

public class CodeBlockDemo
{
    {
        System.out.println("初始化代码");
    }

    CodeBlockDemo()
    {
        System.out.println("构造器");
    }   

    static
    {
        System.out.println("静态代码块");
    }
    
    //运行后输出结果?
    public static void main(String[] args) 
    {   
        {
            int a = 10;
            //10
            System.out.println("局部代码块");
        }

        new CodeBlockDemo();
        System.out.println("--------------------------");
        new CodeBlockDemo();
        System.out.println("--------------------------");
        new CodeBlockDemo();
    }
}