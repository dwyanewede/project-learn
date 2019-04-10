package com.learn.demo.design.spring.pattern.creation.singleton.singleton.v4;

// 枚举单例
public enum EnumSingleton {
    INSTANCE;
 
    // 添加单例方法
    public void method() {
        System.out.println("Singleton method called...");
    }
}
