package com.learn.demo.java.classloader;

public class StaticDemo5 {
//	执行顺序：
//
//	①进行解析，i = 0; // 这里是标记值
//
//	③执行到2处检查i是否赋值，结果2处没有赋值，所以就将标量值赋给了i
//
//	④i的最终值为7。

	public static void main(String[] args) {
		System.out.println(Demo.i);
	}
 
}
 
class Demo {
 
	static {
		i = 7; // 1
	}
	static int i; // 2
 
}