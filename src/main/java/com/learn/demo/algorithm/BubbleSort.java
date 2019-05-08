package com.learn.demo.algorithm;

import java.util.Arrays;

/**
 * @ClassName: BubbleSort
 * @Description: 冒泡排序
 * @Author: 尚先生
 * @CreateDate: 2019/2/27 14:46
 * @Version: 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        bubbleSort();
    }

    /**
     * 冒泡排序
     */
    private static void bubbleSort() {
        int[] arr = {6, 3, 8, 2, 9, 1};
        System.out.println("排序前数组为：");
        printArray(arr);
        boolean flag;
        // 后续改为Lambda实现
        for (int i = 0; i < arr.length - 1; i++) {//外层循环控制排序趟数
            flag  = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {//内层循环控制每一趟排序多少次
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag  = true;
                }
            }
            // 判断整个一层循环是否有序
            if(flag == false){
                System.out.println("排序后的数组为：");
                printArray(arr);
                return;
            }
        }
        System.out.println("排序后的数组为：");
        printArray(arr);
    }

    /**
     * 打印当前数组
     * @param arr
     */
    private static void printArray(int[] arr) {
        Arrays.stream(arr).forEach(con -> System.out.println(con));
    }
}