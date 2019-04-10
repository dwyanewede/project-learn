package com.learn.demo.design.spring.pattern.creation.abstractfactory;

// 电器工厂接口
public interface IElectricalFactory {
	
	IFan createFan();
	
	ITubeLight createTubeLight();
}
