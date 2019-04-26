package com.learn.demo.data.structure;

import java.util.LinkedHashMap;

/**
 * @ClassName: LInkedHashMapQuestion
 * @Description: LinkedHashMap使用
 * @Author: 尚先生
 * @CreateDate: 2019/4/26 9:35
 * @Version: 1.0
 */
public class LInkedHashMapQuestion {

    //默认创建的 map 等同于 hashMap
    //private static LinkedHashMap map = new LinkedHashMap();
    //创建支持顺序存储的 map
    private static LinkedHashMap<String,Integer> map = new LinkedHashMap(16,0.75f,true);

    public static void main(String[] args) {
        testPut();
        testGet();
        testListIterator();
    }

    private static void testListIterator() {
        map.values().forEach(value -> System.out.println("LinkedHashMap 存储数据列表：" + value ));
    }

    private static void testGet() {
        Integer integer = map.get("7");
        System.err.println("LinkedHashMap get 结果：" + integer);
    }

    private static void testPut() {
        map.put("1",2);
        map.put("3",4);
        map.put("7",8);
        map.put("5",6);
        map.put("7",0);
    }

    // 默认创建的 map输出结果
    // LinkedHashMap 存储数据列表：2
    // LinkedHashMap 存储数据列表：4
    // LinkedHashMap 存储数据列表：0
    // LinkedHashMap 存储数据列表：6

    // 创建new LinkedHashMap(16,0.75f,true);
    // LinkedHashMap 存储数据列表：2
    // LinkedHashMap 存储数据列表：4
    // LinkedHashMap 存储数据列表：6
    // LinkedHashMap 存储数据列表：0

}
