package com.learn.demo.design.spring.pattern.structural.decorator;

//Concrete Decorator
public class NameCardDecorator extends Decorator {

	protected NameCardDecorator(BakeryComponent baseComponent) {
		super(baseComponent);
		this.name = "Name Card";
		this.price = 4.0;
	}

	@Override
	public String getName() {
		return super.getName() + 
				"(Please Collect your discount card for " + 
				this.price + 
				")";
	}

}
