package com.learn.demo.dubbo.extension;

import org.apache.dubbo.common.extension.ExtensionLoader;

public class ExtensionTest {
    public static void main(String[] args) {
        MyExtension extension = ExtensionLoader.getExtensionLoader(MyExtension.class).getAdaptiveExtension();
        System.out.println(extension.sayHello("尚先生","qwer"));
// ExtensionLoader.getExtensionLoader(Transporter.class).getAdaptiveExtension();
    }
}