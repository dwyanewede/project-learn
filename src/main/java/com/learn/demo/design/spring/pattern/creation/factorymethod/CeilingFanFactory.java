package com.learn.demo.design.spring.pattern.creation.factorymethod;

public class CeilingFanFactory implements IFanFactory {

	@Override
	public IFan createFan() {
		return new CeilingFan();
	}

}
