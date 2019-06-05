package com.learn.demo.java.base.reference;

/**
 * @ClassName: Test2
 * @Description: 数据引用类型实例测试
 * @Author: 尚先生
 * @CreateDate: 2019/6/5 15:23
 * @Version: 1.0
 */
public class Test2 {
 
    public static void setValue(String str){
        str = "ss";
    }
    public static void setValue(Man str){
        str = new Man("test");
    }
 
    public static class Man{
        private String name;
 
        public String getName() {
            return name;
        }
 
        public void setName(String name) {
            this.name = name;
        }
 
        public Man(String name) {
            this.name = name;
        }

        public Man() {
        }

        @Override
        public String toString() {
            return "Man{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
 
    public static void main(String[] args) {
 
        String str = "s";
        setValue(str);
 
        System.out.println(str);
 
 
        Man man = null;
        setValue(man);
        System.out.println(man);


        Man mans = new Man();

        setManValue(mans);

        System.out.println(mans);
    }

    private static void setManValue(Man mans) {

        mans.setName("sxs");
    }
}