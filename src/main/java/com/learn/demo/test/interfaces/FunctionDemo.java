package com.learn.demo.test.interfaces;

import java.util.function.Function;

/**
 * @ClassName: FunctionDemo
 * @Description: 接口设计
 * @Author: 尚先生
 * @CreateDate: 2018/12/21 9:57
 * @Version: 1.0
 */
public class FunctionDemo {
    public static void main(String[] args) {

        UserService userService = new UserService();
        ServiceInvoker<UserService> serviceInvoker = new DefaultServiceInvoker<UserService>(userService);
        String result = serviceInvoker.invoke(service -> userService.find(1));
        System.out.println("输出结果：" + result);
    }

    public static class UserService{

        public String find(long id){
            return "sxs";
        }
//        BindingResult result = new B
    }

    public interface ServiceInvoker<T>{
        <R> R invoke(Function<T, R> func);
    }

    public static class DefaultServiceInvoker<T> implements ServiceInvoker{

        private final T service;

        public DefaultServiceInvoker(T service) {
            this.service = service;
        }

        @Override
        public Object invoke(Function func) {
            System.out.println("----function----");
            return func.apply(service);
        }
    }
}
