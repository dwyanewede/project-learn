package com.learn.demo.design.spring.pattern.structural.bridge;

//Concrete Implementor
public class WindowsFileDownloadImplementor implements FileDownloadImplementor {

	@Override
	public Object downloadFile(String path) {
		return new Object();
	}

	@Override
	public boolean storeFile(Object object) {
		System.out.println("File download successfully in WINDOWS !!");
		return true;
	}

}
