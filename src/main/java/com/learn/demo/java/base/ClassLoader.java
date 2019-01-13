package com.learn.demo.java.base;

public class ClassLoader {
	public static void main(String[] args) {
		Childern childern =new Childern();
	}
}
 
class Parent{
	static{
		System.out.println("父类静态代码块1");
	}
	static String tem=aa();
	
	static String aa(){
		System.out.println("父类的静态方法");
		return "";
	}
	public Parent(){
		System.out.println("父类的构造方法");
	}
	static{
		System.out.println("父类静态代码块2");
	}
	
	{
		System.out.println("父类非静态代码块1");
	}
	
	String temp = tt();		
	String tt(){
		System.out.println("父类的成员方法");
		return "成员方法";
	}
	{
		System.out.println("父类非静态代码块2");
	}
}
 
 
class Childern extends Parent{
	static{
		System.out.println("子类静态代码块1");
	}
	static String tem=aa();
	
	static String aa(){
		System.out.println("子类的静态方法");
		return "";
	}
	public Childern(){
		System.out.println("子类的构造方法");
	}
	static{
		System.out.println("子类静态代码块2");
	}
	
	{
		System.out.println("子类非静态代码块1");
	}
	
	String temp = TT();		
	String TT(){
		System.out.println("子类的成员方法");
		return "成员方法";
	}
	{
		System.out.println("子类非静态代码块2");
	}
}