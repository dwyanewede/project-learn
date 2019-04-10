package com.learn.demo.design.spring.pattern.structural.decorator;

//Concrete Decorator
public class CherryDecorator extends Decorator {

	protected CherryDecorator(BakeryComponent baseComponent) {
		super(baseComponent);
		this.name = "Cherry";
		this.price = 2.0;
	}

}
