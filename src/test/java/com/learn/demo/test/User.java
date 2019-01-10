package com.learn.demo.test;

/**
 * @ClassName: User
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/13 18:59
 * @Version: 1.0
 */
public class User {

    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
