package com.learn.demo.design.spring.pattern.behavior.interpreter;

// Expression
public abstract class Expression {
	
	public abstract int interpret();
	
	@Override
	public abstract String toString();

}
