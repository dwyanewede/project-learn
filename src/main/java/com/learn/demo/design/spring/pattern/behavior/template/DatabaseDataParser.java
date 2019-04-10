package com.learn.demo.design.spring.pattern.behavior.template;

public class DatabaseDataParser extends DataParser {

	@Override
	void readData() {
		System.out.println("Reading data from database");
	}

	@Override
	void processData() {
		System.out.println("Looping through records in DB");
	}

}
