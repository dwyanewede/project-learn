package com.learn.demo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestJava8 {
 
    public static void main(String[] args) {
 
        List<String> alpha = Arrays.asList("a", "b", "c", "d");
 
        //Before Java8
        List<String> alphaUpper = new ArrayList<>();
        for (String s : alpha) {
            alphaUpper.add(s.toUpperCase());
        }
 
        System.out.println(alpha); //[a, b, c, d]
        System.out.println(alphaUpper); //[A, B, C, D]
 
        // Java 8
        List<String> collect1 = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect1); //[A, B, C, D]

        System.out.println("---------------------------------");

        List<String> collect2 = alpha.stream().map(key -> toAppend(key)).collect(Collectors.toList());
        System.out.println(collect2); //[a sxs, b sxs, c sxs, d sxs]

        System.out.println("---------------------------------");

        List<String> collect3 = alpha.stream().map(key -> toAppend(key)).filter(key -> key.startsWith("a sxs")).collect(Collectors.toList());
        System.out.println(collect3); //[a sxs]

        System.out.println("---------------------------------");

        List<String> collect4 = Stream.of(collect3,collect3).flatMap(cousumer -> cousumer.stream()).collect(Collectors.toList());
        System.out.println(collect4); //[a sxs, a sxs]


        // Extra, streams apply to any data type.
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> collect = num.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(collect); //[2, 4, 6, 8, 10]
 
    }




    public static String charAt(String key) {
        return key;
    }

    public static String toAppend(String key) {
        return key + " sxs";
    }
 
}