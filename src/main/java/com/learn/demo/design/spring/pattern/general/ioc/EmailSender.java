package com.learn.demo.design.spring.pattern.general.ioc;

public class EmailSender implements INotifier {

	public void notify(String message) {
		// 发送Email
		System.out.println("Send email, message : " + message);
	}

}
