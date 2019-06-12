package com.learn.demo.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: TestFinalMap
 * @Description: 测试 HashMap
 * @Author: 尚先生
 * @CreateDate: 2019/5/18 15:13
 * @Version: 1.0
 */
public class TestFinalMap {

    public static final ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<>();
    public static final Map<String,Object> hashMap = new HashMap<>();



    public static void main(String[] args) {

        Map<String, Object> map = getMap();
        map.put("6",6);
        print();
    }

    private static final Map<String,Object> getMap() {
        hashMap.put("1","1");
        hashMap.put("2","2");
        hashMap.put("3","3");
        hashMap.put("4","4");
        hashMap.put("5","7");
        hashMap.put("5","8");
        return hashMap;
    }

    private static void print() {
        hashMap.forEach((k,v) -> System.out.println("key :" + k + "  " + "v :" + v));
    }
}
