package com.learn.demo.design.spring.pattern.general.injection;

import com.learn.demo.design.spring.pattern.general.ioc.EventLogWriter;
import com.learn.demo.design.spring.pattern.general.ioc.INotifier;

public class AppMonitorConstructorInjection {
	// 事件通知器
	private INotifier notifier = null;
	
	public AppMonitorConstructorInjection(INotifier notifier) {
		this.notifier = notifier;
	}
	
	// 应用有问题时该方法被调用
	public void notify(String message) {
		notifier.notify(message);
	}
	
	public static void main(String[] args) {
		EventLogWriter writer = new EventLogWriter();
		AppMonitorConstructorInjection monitor = 
				new AppMonitorConstructorInjection(writer);
		monitor.notify("App has a problem ...");
	}
	
}
