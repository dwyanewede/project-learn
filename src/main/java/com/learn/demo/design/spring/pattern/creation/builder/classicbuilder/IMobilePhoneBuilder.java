package com.learn.demo.design.spring.pattern.creation.builder.classicbuilder;

// 这个是构建者"Builder"接口
public interface IMobilePhoneBuilder {
	void buildScreen();
	void buildBattery();
	void buildOS();
	void buildStylus();
	MobilePhone getPhone();
}
