package com.learn.demo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: JavaLambda
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2019/5/6 17:30
 * @Version: 1.0
 */
public class JavaLambda {

    public static void main(String[] args) {
        tsetToMap();
    }

    private static void tsetToMap() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Supplier<Map<Integer,Integer>> mapSupplier = () -> list.stream().collect(Collectors.toMap(x->x, y-> y * y));

        mapSupplier.get().forEach((key,value) -> System.out.println("key: " + key + "  " + "value: " + value));

        Map<Integer, Integer> mapValueAdd = list.stream().collect(Collectors.toMap(x->x, y->y, (key,value) -> key * value ,mapSupplier));
        System.out.println("mapValueAdd: "+ mapValueAdd);

        Optional<Double> optional = list.stream().map(mapper -> mapper.doubleValue()).reduce((aDouble, aDouble2) -> aDouble + aDouble2);
        float floatValue = optional.get().floatValue();
        System.out.println("map reduce 结果：" + floatValue);

//        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 9), Arrays.asList(1, 8, 27));

        List<Integer> nums = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(1,4,9), Arrays.asList(1,8,27))
                .stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        System.out.println("toList: " + nums);
    }
}
