package com.learn.demo.file;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @ClassName: SpringFileAccessDemo
 * @Description: Spring 读取配置文件
 * @Author: 尚先生
 * @CreateDate: 2018/12/11 17:33
 * @Version: 1.0
 */
public class SpringFileAccessDemo1 {

    public static void main(String[] args) throws Exception {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("application.properties");
        InputStream inputStream = resource.getInputStream();
        String toString = StreamUtils.copyToString(inputStream, Charset.forName("UTF-8"));
        System.out.println(toString);
    }
}
