package com.learn.demo.design.spring.pattern.structural.facade;

// 支付接口
public interface IPaymentGateway {
	public boolean verifyCardDetails(String cardNo);
	public boolean processPayment(String cardNo, float cost);
}
