package com.learn.demo.dubbo.extension;

public class DefaultExtension implements MyExtension {
    @Override
    public String sayHello(String name, String extensionType) {
        return "This is DEFAULT implementation, and hello - "+name;
    }
}