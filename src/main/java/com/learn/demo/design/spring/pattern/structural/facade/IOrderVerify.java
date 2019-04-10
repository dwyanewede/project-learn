package com.learn.demo.design.spring.pattern.structural.facade;

// 订单校验接口
public interface IOrderVerify {
	public boolean verifyShippingAddress(int pincode);
}
