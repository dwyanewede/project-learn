package com.learn.demo.design.spring.pattern.creation.abstractfactory;

public class ChineseElectricalFactory implements IElectricalFactory {

	public IFan createFan() {
		return new ChineseFan();
	}

	public ITubeLight createTubeLight() {
		return new ChineseTubeLight();
	}

}
