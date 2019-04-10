package com.learn.demo.design.spring.pattern.structural.bridge;

// Implementor
public interface FileDownloadImplementor {
	
	public Object downloadFile(String path);
	
	public boolean storeFile(Object object);
	
}
