package com.learn.demo.java.classloader;

/**
 * 这里最最重要的一点就是，当加载到一个静态属性的时候他的赋值对象为一个静态的对象，
 * 这个时候就会中断静态相关的加载，转而先去执行非静态相关的代码。
 * 这里还需要注意的是属性和代码块的加载遵循他们的先后出场顺序。
 */
public class Text {
 
	public static int k = 0;
	public static Text t1 = new Text("t1"); // 1.这里的静态属性赋有一个非静态的对象 所以停止类加载转向所有的非静态初始化 
	public static Text t2 = new Text("t2");// 6.由于上一句静态代码以及相关的非静态代码执行完毕所以来到了下一句静态代码的执行
	public static int i = print("i");
	public static int n = 99;
 
	public int j = print("j");// 2.这是第一个非静态属性它的赋值调用print("j")方法 // 7.原理和1的执行过程类似
 
	{// 4.现在2.处的非静态属性终于初始化完毕，所以接着来到了非静态块此时 k = 2, i = 1, n = 1   
		print("构造块");
	}
 
	static {
		print("静态块");
	}
 
	public Text(String str) {// 5.非静态块执行完毕之后来到了构造方法（它本身也是非静态的）此时k = 3, i = 2, n = 2  
		System.out.println((++k) + ":" + str + " i = " + i + " n = " + n);
		++i;
		++n;
	}
 
	public static int print(String str) {// 3.来自2.的调用此时k = 1, i = 0, n = 0  
		System.out.println((++k) + ":" + str + " i = " + i + " n = " + n);
		++n;
		return ++i;
	}
 
	public static void main(String[] args) {
		Text t = new Text("init");
	}
}