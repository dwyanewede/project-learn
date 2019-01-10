package com.learn.demo.dubbo.extension;

public class SWExtension implements MyExtension {
    @Override
    public String sayHello(String name, String extensionType) {
        return "This is SW implementation, and hello - "+name;
    }
}