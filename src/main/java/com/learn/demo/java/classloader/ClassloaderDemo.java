package com.learn.demo.java.classloader;

public class ClassloaderDemo {
 
	public static void main(String[] args) {
 		new SB();
	}
	
 
}
 
class SA {
 
	D d;
 
	static {
		System.out.println("A 1"); // 1.先从父类的非静态开始
	}
 
	{
		System.out.println("A 2"); // 5.此处开始new对象（非静态相关）
		d = new D();// 6.顺序执行
	}
 
	public SA() {
		System.out.println("A 3"); // 10.此时调用完了自己的非静态代码块来到了构造器
	}
 
}
 
class SB extends SA {
	static C c = new C(); // 2.调用完了父类的静态相关来到子类的静态相关
 
	static {
		System.out.println("B 1"); // 4.接着按照顺序来调用自己的静态代码块 ，到此子类的所有静态都执行完毕接下来将会执行非静态相关
	}
 
	{
		System.out.println("B 2"); // 11.父类的构造器调用完成调用子类的非静态块
	}
 
	public SB() {
		System.out.println("B 3"); // 12.调用完了自己的非静态块调用自己的构造方法 
	}

}
 
class C {
	public C() {
		System.out.println("C"); // 3.C没有父类与静态直接调用自己的构造器  // 8.
	}
}
 
class D extends C {// 7. 来到了D但是D有自己的父类所以到达C类
	public D() {
		System.out.println("D");// 9.调用完了父类的构造器会来到子类的构造器
	}
}

//	A 1
//	C
//	B 1
//	A 2
//	C
//	D
//	A 3
//	B 2
//	B 3