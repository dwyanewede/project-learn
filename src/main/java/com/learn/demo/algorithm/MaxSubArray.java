package com.learn.demo.algorithm;

/**
 * @ClassName: MaxSubArray
 * @Description: 数组最大连续子序列和
 * @Author: 尚先生
 * @CreateDate: 2019/2/28 10:57
 * @Version: 1.0
 */
public class MaxSubArray {


    /**
     * 方法一，时间复杂度O(n^3)
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int thisSum, maxSum = Integer.MIN_VALUE, i, j, k;
        int length = nums.length;
        for (i = 0; i < length; i++) {
            for (j = i; j < length; j++) {
                thisSum = 0;
                for (k = i; k <= j; k++) {
                    thisSum += nums[k];
                }
                if (thisSum > maxSum)
                    maxSum = thisSum;
            }
        }
        return maxSum;
    }


    /**
     * 方法二，时间复杂度O(n)
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums)
    {
        int length = nums.length;
        if(length <= 0)
            return 0;
        int CurSum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < length; i++)
        {
            if(CurSum <= 0)     //当当前的和小于等于0，那么就给其置为当前元素的值
                CurSum = nums[i];
            else
                CurSum += nums[i];
            if(CurSum > max)
                max = CurSum;
        }
        return max;
    }
}
