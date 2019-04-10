package com.learn.demo.design.pattern;

/**
 * @ClassName: Fluent
 * @Description: 流畅接口模式设计
 * @Author: 尚先生
 * @CreateDate: 2019/4/10 10:07
 * @Version: 1.0
 */
public class Fluent {

    private String firstName;
    private String lastName;
    private int age;
    private String address;

    private Fluent(FluentBuilder fluentBuilder){
        this.firstName = fluentBuilder.firstName;
        this.lastName = fluentBuilder.lastName;
        this.age = fluentBuilder.age;
        this.address = fluentBuilder.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Fluent{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    // 自定义静态Builder类
    static class FluentBuilder{
        private final String firstName;
        private final String lastName;
        private int age;
        private String address;

        public FluentBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public FluentBuilder age(int age){
            this.age = age;
            return this;
        }
        public FluentBuilder address(String address){
            this.address = address;
            return this;
        }

        public Fluent builder(){
            Fluent fluent = new Fluent(this);
            validateFluent(fluent);
            return fluent;
        }

        private void validateFluent(Fluent fluent) {
            System.out.println("校验参数合法性...");
        }
    }
}
