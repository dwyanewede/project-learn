package com.learn.demo.data.structure;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @ClassName: LinkedListQuestion
 * @Description: LinkedList使用
 * @Author: 尚先生
 * @CreateDate: 2019/4/25 15:54
 * @Version: 1.0
 */
public class LinkedListQuestion {


    private static LinkedList<Integer> linkedList = new LinkedList<>();

    public static void main(String[] args) {

        testAdd();
        testAddFirst();
        testAddLast();
        testRemove();
        testPush();
        testPop();
        testPeek();
        testListIterator();
    }

    private static void testPeek() {
        // 等价于 peekFirst 只取不删
        Integer integer = linkedList.peek();
        System.err.println("peek 结果：" + integer);
    }

    private static void testPush() {
        // 等价于 addFirst
        linkedList.push(-1);
    }

    private static void testPop() {
        // 等价于 removeFirst
        Integer pop = linkedList.pop();
        System.err.println("pop 结果：" + pop);
    }


    private static void testRemove() {
        //等价于 removeFirst
        linkedList.remove();
    }

    private static void testListIterator() {
        // index 0 -> 1 3 2
        // index 1 -> 3 2
        // index 2 ->  2
        // index为空 = index 0
         ListIterator<Integer> iterator = linkedList.listIterator();
        // 此处会实现从前遍历还是从后遍历动态实现，目的在于选择最短遍历路径
        // 主要实现方法 java.util.LinkedList.node
//        ListIterator<Integer> iterator = linkedList.listIterator(2);
        iterator.forEachRemaining(consumer -> System.out.println("linkedList 遍历结果：" + consumer));

    }

    private static void testAddFirst() {
        linkedList.addFirst(0);

    }

    private static void testAddLast() {
        linkedList.addLast(100);
    }

    private static void testAdd() {
        // add 等价于 offer
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(5);
    }
}
