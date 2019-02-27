package com.learn.demo.algorithm;

/**
 * 一列数的规则如下: 1、1、2、3、5、8、13、21、34 ，求第30位数是多少？使用递归实现
 */
public class FibonacciSequence {
    public static void main(String[] args){
        System.out.println(Fribonacci(9));

    }
    public static int Fribonacci(int n){
        if(n == 1)
            return 1;
        else if (n < 1)
            return 0;
        else
            return Fribonacci(n-1)+Fribonacci(n-2);

    }
}