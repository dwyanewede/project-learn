package com.learn.demo.java.base.reference;

/**
 * @ClassName: PersonTest
 * @Description: 数据引用类型实例测试
 * @Author: 尚先生
 * @CreateDate: 2019/6/5 15:34
 * @Version: 1.0
 */
public class PersonTest {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
