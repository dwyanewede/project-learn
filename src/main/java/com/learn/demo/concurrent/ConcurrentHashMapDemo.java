package com.learn.demo.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: ConcurrentHashMapDemo
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/12 14:42
 * @Version: 1.0
 */
public class ConcurrentHashMapDemo {


    static Map<Integer, Integer> concurrentMap = new ConcurrentHashMap<>();

    public void sayCpu() {

//        System.out.println("Fibonacci result for 20 is" + fibonacci(20));
    }

//    static int fibonacci(int i) {
//        if (i == 0) return i;
//        if (i == 1) return 1;
//        return concurrentMap.computeIfAbsent(i, key> {
//                System.out.println("Value is " + key);
//        return fibonacci(i - 2) + fibonacci(i - 1);});
//    }

    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        if (null == hashMap.get("str") || "123".equals(hashMap.get("str"))){
            System.out.println("000000");
        }
        if (hashMap.get("str").equals("")){
            System.out.println("000000");
        }
    }
}
