package com.learn.demo.design.spring.pattern.structural.proxy;

public class User {
	
	String username;
	String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUserName() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
}
