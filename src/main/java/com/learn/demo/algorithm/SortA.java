package com.learn.demo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: SortA
 * @Description: 找出 list 中所有对应的 A 元素
 * @Author: 尚先生
 * @CreateDate: 2019/5/20 17:56
 * @Version: 1.0
 */
public class SortA {


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        // 初始化 ArrayList
        initList(list);


        // 方法一： Lambda 表达式 foreach
        // List<String> strings = filter(list);
        // 打印数据
        // print(strings);


        // 方法二： for循环实现 foreach
        List<String> strings = foreach(list);
        // 打印数据
        print(strings);
    }

    private static List<String> foreach(List<String> list) {
        // 递归实现 for 循环
        boolean b;
        do {
            b = doforeach(list);
        }while (!b);
        return list;
    }

    /**
     *
     * @param list
     * @return
     */
    private static boolean doforeach(List<String> list) {
        boolean flag = false;
        int length = list.size();
        for (int i = 0; i < length; i++){
            if ("A".equals(list.get(i))){
                System.out.println("待删除的元素下标：" + i);
                list.remove(i);
                return i == length;
            }
        }
        return true;
    }


    /**
     * 打印过滤后的信息
     * @param list
     */
    private static void print(List<String> list) {
        list.forEach(con -> System.out.println("过滤后的数据： " + con));
    }


    /**
     * 过滤、遍历数据
     * @param list
     */
    private static List<String> filter(List<String> list) {
        list =  list.stream().filter(con -> {
            return !"A".equals(con);
        }).collect(Collectors.toList());
        return list;
    }

    /**
     * 初始化 ArrayList
     * @param list
     */
    private static void initList(List<String> list) {
        List<String> stringList = Arrays.asList("C", "D", "F", "A", "M", "O", "P", "A", "W", "E", "A", "L", "J", "T", "A");
        // List<String> stringList = Arrays.asList("A","A","B","A");
        list.addAll(stringList);
        System.out.println("初始化完成后数据容量： " + list.size());
    }
}
