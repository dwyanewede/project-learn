package com.learn.demo.file;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * @ClassName: SpringFileAccessDemo
 * @Description: Spring 读取配置文件
 * @Author: 尚先生
 * @CreateDate: 2018/12/11 17:33
 * @Version: 1.0
 */
public class SpringFileAccessDemo {

    private final static String URL_PREFIX = "cp:/";

    public static void main(String[] args) throws Exception {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        resourceLoader.addProtocolResolver(new ProtocolResolver() {
            @Override
            public Resource resolve(String location, ResourceLoader resourceLoader) {
                if (location.startsWith(URL_PREFIX)) {
                    String substring = location.substring(URL_PREFIX.length());
                    Resource resource = resourceLoader.getResource(substring);
                    return resource;
                }
                return null;
            }
        });
        Resource resource = resourceLoader.getResource("cp:/application.properties");
        URL url = resource.getURL();
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        String toString = StreamUtils.copyToString(inputStream, Charset.forName("UTF-8"));
        System.out.println(toString);
    }
}
