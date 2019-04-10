package com.learn.demo.design.spring.pattern.structural.facade;

// 库存实现
public class InventoryManager implements IInventory {

	@Override
	public void update(int productId) {
		String msg = "Product# " + productId + 
				" is subtracted from store's inventory";
		System.out.println(msg);
	}

}
