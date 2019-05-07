package com.learn.demo.algorithm.test;

import java.util.LinkedList;

/**
 * @ClassName: DuplicateNums
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2019/3/6 8:40
 * @Version: 1.0
 */
public class DuplicateNums {

    private static LinkedList<Integer> linkedList = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,6,4,5,6,7,4,2};
        int length = nums.length;
        duplicate(nums,length,linkedList);
        linkedList.forEach(consumer -> System.out.println(consumer.intValue()));
    }

    public static boolean duplicate(int[] nums, int length, LinkedList<Integer> linkedList) {
        if (nums == null || length <= 0)
            return false;
        for (int i = 0; i < length; i++) {
           for (int j = i + 1; j < length; j++){
               if (nums[i] == nums[j]){
                   linkedList.add(nums[i]);
               }
           }
        }
        return true;
    }

}
