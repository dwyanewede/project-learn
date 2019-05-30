package com.learn.demo.java.classloader;

public class StaticDemo7 {

//	①首先进行解析 i = 0,j = 0 //标记值
//
//	②停止静态的类加载，执行构造器中的方法，标记值发生了运算，i = 1,j = 1
//
//	③执行到2处，i = 5
//
//	④执行到3处j没有赋值，默认使用标记值1
//
//	⑤执行静态代码块i = 6，j = 2

	public static void main(String[] args) {
		System.out.println(E.i);
		System.out.println(E.j);
	}
}
 
class E {
	static E e = new E();// 1
	static int i = 5;// 2
	static int j;// 3
	static {
		System.out.println(" static   " + "i: " +  i + "  j: " + j);
		E.i++;
		E.j++;
	}
	
	public E() {
		System.out.println(" E()   " + "i: " +  i + "  j: " + j);
		i++;
		j++;
	}
}