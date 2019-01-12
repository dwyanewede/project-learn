package com.learn.demo;

import com.learn.demo.spi.IPrint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//@ServletComponentScan("com.learn.demo.servlet")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DemoApplication {

    /**
     * 自定义扩展 Spring SPI机制的实现
     * @param printProxy
     */
    public DemoApplication(IPrint printProxy) {
        printProxy.execute(10, " log print ");
        printProxy.execute(0, " console print ");
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

