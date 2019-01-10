package com.learn.demo.design.pattern;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ClassName: CompositeDemo
 * @Description: 组合模式实现
 * @Author: 尚先生
 * @CreateDate: 2018/12/19 9:59
 * @Version: 1.0
 */
public class CompositeDemo {

    public interface A{
        void save();
    }

    public static class AImpl implements A{

        @Override
        public void save() {
            System.out.println("执行A的实现...");
        }
    }

    // 组合模式
    // 此处可选择实现接口A
    public static class CompositeA /*implements A*/{

        private static Collection<A> values = new ArrayList<>();
//        @Override
        public void save() {
            values.forEach(val -> val.save());

        }

        public  static void addA(A a){
            values.add(a);
        }
    }

    public static void main(String[] args) {
        CompositeA.addA(new AImpl());
        new CompositeA().save();
    }
}
