package com.learn.demo.design.spring.pattern.behavior.command;

// Receiver Interface
public interface FileSystemReceiver {
	void openFile();
	void writeFile();
	void closeFile();
}
