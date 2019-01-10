package com.learn.demo.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: FunctionDesignDemo
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/18 19:00
 * @Version: 1.0
 */
public class FunctionDesignDemo {

    public static void main(String[] args) {
        // 1- 10 累加
        List<Integer> value = range(1, 10);
        Integer reduce = value.stream().reduce(0, Integer::sum);
        System.out.println("reduce " + reduce);
        value.forEach(System.out::println);
        System.out.println("-----------------------------");
        demoFlatMap();

    }

    private static List<Integer> range(int since, int count){
        List<Integer> array = new ArrayList<>(count);
        for (int i = since; i <= count; i++){
            array.add(i);
        }
        return array;
    }

    private static void demoFlatMap(){
        String reduce = Arrays.asList("A,B", "C,D,E")
                .stream()
                // 一维转二维
                .map(value -> value.split(","))
                .flatMap(values -> Arrays.stream(values))
                .reduce("i love you ",FunctionDesignDemo::concatValue);
//                .reduce(FunctionDesignDemo::concatValue);
//                .forEach(System.out::println);

        System.out.println("-----FunctionDesignDemo----- " + reduce);
    }

    public static String concatValue(String val1, String val2){
        return val1.concat(val2);
    }




}
