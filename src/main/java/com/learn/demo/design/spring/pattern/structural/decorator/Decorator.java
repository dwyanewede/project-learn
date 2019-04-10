package com.learn.demo.design.spring.pattern.structural.decorator;

// Decorator
public abstract class Decorator implements BakeryComponent {
	
	private BakeryComponent baseComponent = null;
	
	protected String name = "Undefined Decorator";
	protected double price = 0.0;
	
	protected Decorator(BakeryComponent baseComponent) {
		this.baseComponent = baseComponent;
	}

	@Override
	public String getName() {
		return this.baseComponent.getName() + ", " + this.name;
	}

	@Override
	public double getPrice() {
		return this.price + this.baseComponent.getPrice();
	}

}
