package com.learn.demo.test.spi;

import com.learn.demo.java.spi.Robot;
import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @ClassName: JavaSPITest
 * @Description: JavaSPITest实现
 * @Author: 尚先生
 * @CreateDate: 2019/3/17 10:57
 * @Version: 1.0
 */
public class JavaSPITest {
    @Test
    public void sayHello() throws Exception {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}
