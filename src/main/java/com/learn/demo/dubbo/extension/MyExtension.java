package com.learn.demo.dubbo.extension;

import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @ClassName: MyExtension
 * @Description: dubbo SPI扩展机制
 * @Author: 尚先生
 * @CreateDate: 2019/1/7 18:52
 * @Version: 1.0
 */
@SPI("default")
public interface MyExtension {
    @Adaptive
    String sayHello(String name, String extensionType);
}