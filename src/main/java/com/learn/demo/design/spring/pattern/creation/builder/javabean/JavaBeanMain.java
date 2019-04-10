package com.learn.demo.design.spring.pattern.creation.builder.javabean;

public class JavaBeanMain {

	// JavaBean构造对象
	public static void main(String[] args) {
		User user = new User();
		user.setFirstName("william");
		user.setLastName("yang");
		user.setAge(35);
		user.setPhone("18001756666");
		user.setAddress("shanghai pudong");
	}

}
