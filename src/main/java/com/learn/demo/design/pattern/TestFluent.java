package com.learn.demo.design.pattern;

/**
 * @ClassName: TestFluent
 * @Description: 流畅接口模式设计测试类
 * @Author: 尚先生
 * @CreateDate: 2019/4/10 10:13
 * @Version: 1.0
 */
public class TestFluent {

    public static void main(String[] args) {
        Fluent fluent1 = new Fluent.FluentBuilder("shang", "xiansheng").age(18).address("he nan").builder();
        System.out.println("创建的第一个对象：" + fluent1);

        Fluent fluent2 = new Fluent.FluentBuilder("shang", "xiansheng").age(18).builder();
        System.out.println("创建的第二个对象：" + fluent2);

        Fluent fluent3 = new Fluent.FluentBuilder("shang", "xiansheng").address("he nan").builder();
        System.out.println("创建的第三个对象：" + fluent3);
    }
}
