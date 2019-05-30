package com.learn.demo.java.classloader;

public class StaticDemo6 {

//	①进行解析，i = 0; // 这里是标记值
//
//	②按照静态出现的顺序来加载。执行到1处，此时i的标记值发生了运算它改为了1。
//
//	③执行到2处检查i是否赋值，结果将5赋值给了i
//
//	④i的最终值为5。

	public static void main(String[] args) {
 
		// new SDemo();
		System.out.println(SDemo.i);
 
	}
 
}
 
class SDemo {

	static {
		System.out.println(++SDemo.i); // 1
	}

	static int i = 5;
}