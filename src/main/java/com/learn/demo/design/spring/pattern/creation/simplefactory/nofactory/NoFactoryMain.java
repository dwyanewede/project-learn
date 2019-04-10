package com.learn.demo.design.spring.pattern.creation.simplefactory.nofactory;

public class NoFactoryMain {

	public static void main(String[] args) {
		TableFan fan = new TableFan();
		fan.switchOn();
	}

}

class TableFan {
	public void switchOn() {
		System.out.println("The TableFan is switched on ...");
	}
}
