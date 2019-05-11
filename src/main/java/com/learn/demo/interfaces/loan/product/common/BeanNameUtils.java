package com.learn.demo.interfaces.loan.product.common;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

/**
 * @ClassName: BeanNameUtils
 * @Description: BeanName 获取工具类， 从配置文件中读取对应的 BeanName
 * @Author: 尚先生
 * @CreateDate: 2019/5/10 16:46
 * @Version: 1.0
 */
@Component
@PropertySource(value = "classpath:interfaces/pattern/app-product.properties")
public class BeanNameUtils {

    @Autowired
    private Environment environment;

    public String getBeanName(String transCode, String productCode, String channelId){
        // 由于是局部变量，不存在线程安全问题，故此采用 StringBuilder
        StringBuilder key = new StringBuilder();
        key.append(transCode).append("-" + productCode).append("-" + channelId);
        String value = environment.getProperty(key.toString());
        System.out.println("获取的BeanName为： " + value);
        return value;
    }

}
