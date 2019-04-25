package com.learn.demo.algorithm;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: FastSort
 * @Description: 直接插入排序 稳定算法
 * @Author: 尚先生
 * @CreateDate: 2019/2/27 14:46
 * @Version: 1.0
 */
public class InsertSort {
    public static void main(String[] args) throws InterruptedException {
        String s = new String("abc");
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s == s1.intern());
        System.out.println(s == s2.intern());
        System.out.println(s1 == s2.intern());
        System.out.println(s1 == s.intern());
        // TODO Auto-generated method stub
        int a[] = {3, 1, 5, 7, 2, 4, 9, 6};
        int b[] = {3, 1, 5, 7, 2, 4, 9, 6};
        new InsertSort().insertSort(a);
        System.out.println("———————————————————直接插入排序算法分割线—————————————————————");
        TimeUnit.SECONDS.sleep(1);
        new InsertSort().sort(b);
    }

    /**
     * 直接插入排序算法的实现
     * @param a
     */
    private void insertSort(int[] a) {
        // TODO Auto-generated method stub
        int n = a.length;
        int i, j;
        for (i = 1; i < n; i++) {
            /**
             * temp为本次循环待插入有序列表中的数
             */
            int temp = a[i];
            /**
             * 寻找temp插入有序列表的正确位置
             */
            for (j = i - 1; j >= 0 && a[j] > temp; j--) {
                /**
                 * 元素后移，为插入temp做准备
                 */
                a[j + 1] = a[j];
            }
            /**
             * 插入temp
             */
            a[j + 1] = temp;
            print(a, n, i);
        }
        printResult(a, n);
    }

    /**
     * 打印排序的最终结果
     * @param a
     * @param n
     */
    private void printResult(int[] a, int n) {
        System.out.print("最终排序结果：");
        for (int j = 0; j < n; j++) {
            System.out.print(" " + a[j]);
        }
        System.out.println();
    }

    /**
     * 打印排序的每次循环的结果
     *
     * @param a
     * @param n
     * @param i
     */
    private void print(int[] a, int n, int i) {
        // TODO Auto-generated method stub
        System.out.print("第" + i + "次：");
        for (int j = 0; j < n; j++) {
            System.out.print(" " + a[j]);
        }
        System.out.println();
    }


    /**
     * 方法二
     * @param arr
     */
    public void sort(int[] arr) {
        int tmp;
        for (int i = 1; i < arr.length; i++) {
            // 待插入数据
            tmp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                // 判断是否大于tmp，大于则后移一位
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
            System.err.println(i + ":" + Arrays.toString(arr));
        }
    }
    // 1324   tem = 3  a[0] = 1   -> a[1] = tem
}