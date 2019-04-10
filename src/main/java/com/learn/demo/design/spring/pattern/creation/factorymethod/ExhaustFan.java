package com.learn.demo.design.spring.pattern.creation.factorymethod;

public class ExhaustFan implements IFan {

	@Override
	public void swithOn() {
		System.out.println("The ExhaustFan is swithed on ...");
	}

	@Override
	public void switchOff() {
		System.out.println("The ExhaustFan is swithed off ...");
	}
}
