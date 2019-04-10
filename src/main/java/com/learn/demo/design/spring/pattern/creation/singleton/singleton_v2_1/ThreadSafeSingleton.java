package com.learn.demo.design.spring.pattern.creation.singleton.singleton_v2_1;

// �̰߳�ȫ����
public class ThreadSafeSingleton {
	private static ThreadSafeSingleton INSTANCE;
	
	// ˽�й��캯�������ⱻ�ͻ��˴���ʹ��
	private ThreadSafeSingleton(){}

	public static synchronized ThreadSafeSingleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ThreadSafeSingleton();
		}
		return INSTANCE;
	}
}
