package com.learn.demo.design.spring.pattern.structural.facade;

// 费用计算接口
public interface ICosting {
	public float applyDiscount(float price, float discountPercent);
}
