package com.learn.demo.java.proxy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName: Bootstrap
 * @Description: 启动测试类
 * @Author: 尚先生
 * @CreateDate: 2019/6/17 14:58
 * @Version: 1.0
 */
public class Bootstrap {

    public static void main(String[] args) {

        // 动态代理实现
        ReflectionHandler reflectionHandler = new ReflectionHandler(new BuyServiceImpl());

        BuyService proxy = reflectionHandler.getProxy();

        String computer = proxy.buyComputer(proxy);

        String phone = proxy.buyPhone(proxy);

        System.out.println(computer + "\r\n" + phone);


        // spring 采用的 jdk 动态代理
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//
//        context.scan("com.learn.demo.java.proxy");
//
//        context.register(Interceptor.class);
//
//        context.refresh();
//
//        BuyService bean = context.getBean("buyServiceImpl", BuyService.class);
//
//        String phone = bean.buyPhone(bean);
//
//        System.err.println("=========Bootstrap.class============== " + phone);


        createProxyClassFile();

    }


    /**
     * 生成代理文件
     */
    private static void createProxyClassFile() {
        String name = "ProxyBuyService";
        byte[] data = ProxyGenerator.generateProxyClass(name,
                new Class[] {BuyService.class});
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("D://" + name + ".class");
            out.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != out)
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

}
