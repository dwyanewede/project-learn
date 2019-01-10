package com.learn.demo.design.pattern.handler;

/**
 * @ClassName: Person
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/19 18:50
 * @Version: 1.0
 */
public class Person {
    private int id;
    private String name;
    public Person(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    protected synchronized void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
