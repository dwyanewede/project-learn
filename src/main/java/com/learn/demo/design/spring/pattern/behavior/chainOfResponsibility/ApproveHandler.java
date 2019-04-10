package com.learn.demo.design.spring.pattern.behavior.chainOfResponsibility;

// Handler
public interface ApproveHandler {
	
	public void setNextHandler(ApproveHandler nextHandler);
	
	public void approve(Leave leave);
	
}
