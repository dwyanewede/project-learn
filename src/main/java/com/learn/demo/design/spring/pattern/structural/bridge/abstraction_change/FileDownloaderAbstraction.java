package com.learn.demo.design.spring.pattern.structural.bridge.abstraction_change;

public interface FileDownloaderAbstraction {
	public Object download(String path);

	public boolean store(Object object);

	// 添加接口
	public boolean delete(String object);
}