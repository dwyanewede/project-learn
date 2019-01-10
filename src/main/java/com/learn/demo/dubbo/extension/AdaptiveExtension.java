package com.learn.demo.dubbo.extension;

import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.ExtensionLoader;

@Adaptive
public class AdaptiveExtension implements MyExtension {
    public String sayHello(String name, String extensionType) {
        ExtensionLoader<MyExtension> loader = ExtensionLoader.getExtensionLoader(MyExtension.class);
        MyExtension extension = loader.getDefaultExtension();
        switch (extensionType){
            case "default":
                extension = loader.getExtension("default");
                break;
            case "sw":
                extension = loader.getExtension("sw");
                break;
            default:
                break;
        }
        return extension.sayHello(name,extensionType);
    }
}