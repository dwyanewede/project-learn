package com.learn.demo.test;

/**
 * java中创建静态内部类和非静态内部类
 */
class OuterClass{
  private static String msg = "GeeksForGeeks";
  // 静态内部类
  public static class NestedStaticClass{
    // 静态内部类只能访问外部类的静态成员
    public void printMessage() {
     // 试着将msg改成非静态的，这将导致编译错误
     System.out.println("Message from nested static class: " + msg);
    }
  }
  // 非静态内部类
  public class InnerClass{
    // 不管是静态方法还是非静态方法都可以在非静态内部类中访问
    public void display(){
     System.out.println("Message from non-static nested class: "+ msg);
    }
  }
}