package com.learn.demo.design.spring.pattern.creation.abstractfactory;

public class USElectricalFactory  implements IElectricalFactory {

	public IFan createFan() {
		return new USFan();
	}

	public ITubeLight createTubeLight() {
		return new USTubeLight();
	}

}