package com.learn.demo.design.spring.pattern.structural.facade;

// 物流实现
public class LogisticsManager implements ILogistics {

	@Override
	public void shipProducts(String productName, String shippingAddress) {
		String out = String.format(
			"Congratulations your product %s has been shipped at the following address: %s.", 
			productName, shippingAddress);
	    System.out.println(out);
	}

}
