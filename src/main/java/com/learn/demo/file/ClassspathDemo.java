package com.learn.demo.file;

import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * @ClassName: ClassspathDemo
 * @Description: 自定义协议实现文件加载
 * @Author: 尚先生
 * @CreateDate: 2018/12/11 17:50
 * @Version: 1.0
 */
public class ClassspathDemo {
    public static void main(String[] args) throws Exception {
        URL url = new URL("classpath:/application.properties");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        String toString = StreamUtils.copyToString(inputStream, Charset.forName("UTF-8"));
        System.out.println(toString);
    }
}
