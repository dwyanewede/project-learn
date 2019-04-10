package com.learn.demo.design.spring.pattern.creation.factorymethod;

public class TableFanFactory implements IFanFactory {

	@Override
	public IFan createFan() {
		return new TableFan();
	}

}
