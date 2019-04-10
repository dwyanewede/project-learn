package com.learn.demo.design.spring.pattern.creation.builder.classicbuilder;

// 这个是导演"Director"
public class Manufacturer {
	public void construct(IMobilePhoneBuilder phoneBuilder) {
		phoneBuilder.buildBattery();
		phoneBuilder.buildOS();
		phoneBuilder.buildScreen();
		phoneBuilder.buildStylus();
	}
}
