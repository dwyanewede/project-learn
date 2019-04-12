package com.learn.demo.concurrent.xiaomage.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArraysAsListMethodQuestion {

    public static void main(String[] args) {

        // 非线程安全实现
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // 调整第三个元素为 9
        list.set(2, 9);
        // 3 -> 9
        // Arrays.asList 并非线程安全

        printList(list);

        // 线程安全实现
        // Java < 5 , Collections#synchronizedList
        beforejava5();

        // Java 5+  , CopyOnWriteArrayList
        java5();
        // Java 9+  , List.of(...) 只读
        java9();
    }

    private static void printList(List<Integer> list) {
        list.forEach(System.out::println);
    }

    private static void java9() {
        System.out.println("---java9---");
//        List<Integer> list = List.of(1, 2, 3, 4, 5);
//        printList(list);
        System.out.println("---java9---");
    }

    private static void beforejava5() {
        System.out.println("---beforejava5---");
        List<Integer> synchronizedList = Collections.synchronizedList(Arrays.asList(1, 2, 3, 4, 5));
        synchronizedList.set(2,100);
        printList(synchronizedList);
        System.out.println("---beforejava5---");
    }

    private static void java5() {
        System.out.println("---java5---");
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(3);
        copyOnWriteArrayList.add(4);
        copyOnWriteArrayList.add(5);
        copyOnWriteArrayList.set(2,100);
        printList(copyOnWriteArrayList);
        System.out.println("---java5---");
    }
}
