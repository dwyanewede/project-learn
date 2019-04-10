package com.learn.demo.design.spring.pattern.structural.bridge;

// Abstraction
public interface FileDownloaderAbstraction {
	
	public Object download(String path);
	
	public boolean store(Object object);
}
