package com.learn.demo.design.spring.pattern.creation.factorymethod;

public class PropellerFanFactory implements IFanFactory {

	@Override
	public IFan createFan() {
		return new PropellerFan();
	}

}
