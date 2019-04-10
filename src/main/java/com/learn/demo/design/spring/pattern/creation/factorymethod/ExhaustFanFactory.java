package com.learn.demo.design.spring.pattern.creation.factorymethod;

public class ExhaustFanFactory implements IFanFactory {

	@Override
	public IFan createFan() {
		return new ExhaustFan();
	}

}
