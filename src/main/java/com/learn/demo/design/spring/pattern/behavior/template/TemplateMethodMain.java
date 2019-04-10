package com.learn.demo.design.spring.pattern.behavior.template;

public class TemplateMethodMain {

	public static void main(String[] args) {
		CSVDataParser csvDataParser = new CSVDataParser();
		csvDataParser.process();
		System.out.println("**********************");
		DatabaseDataParser databaseDataParser = new DatabaseDataParser();
		databaseDataParser.process();
	}

}
