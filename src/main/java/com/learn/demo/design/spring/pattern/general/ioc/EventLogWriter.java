package com.learn.demo.design.spring.pattern.general.ioc;

public class EventLogWriter implements INotifier {

	public void notify(String message) {
		// 写到事件日志
		System.out.println("Write to event log, message : " + message);
	}

}
