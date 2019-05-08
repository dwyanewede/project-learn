package com.learn.demo.algorithm;

import java.util.Random;

/**
 * @ClassName: NumRandom
 * @Description: 给定一个函数rand()能产生0到n-1之间的等概率随机数，问如何产生0到m-1之间等概率的随机数
 * @Author: 尚先生
 * @CreateDate: 2019/2/28 9:17
 * @Version: 1.0
 */
public class NumRandom {
    int random(int m, int n) {
        if (n < 1 || m < 1)//输入参数错误
            return -1;
        if (m < 2)//小于2则只能生成1
            return 1;
        if (m == n)//和n相同即可
            return rand();
        int max = 0;//组成新n进制数当前位数下最大数
        int k = 0;//随机数
        while (max + 1 < m)//求得新n进制数当前位数下最大数小于m，则继续放大新n进制数的位数
        {
            k = k * n + rand() - 1;//转换成0到n-1的n进制数。一位时0到n-1，两位时0到(n-1)*n+n-1。此时保证了生成0到最大数之间的各个数的概率是相等的
            max = max * n + n - 1;//求n进制数当前位数下的最大数。一位数时n-1,两位数时(n-1)*n+n-1,三位数时(n-1)*n*n+(n-1)*n+n-1
            //随机数超出了范围则重新计算。除m再乘m是为了对生成的k进行分组
            //如m=7，n=5时此处k的范围是0到24，那么25/7=3，3*7=21。
            //因为21、22、23、24都需要重新计算，所以后面返回值k/((max+1)/m)+1就能保证最大值为7了，即20、19、18除3加1都等于7
            //此处也可以不进行分组，直接限定k+1<=m后面返回k即可，这样得到k的概率也是一样的，只不过更不容易得到k，因为大量的k将大于m
            if (max + 1 >= m && k >= (max + 1) / m * m) {
                k = 0;
                max = 0;
            }
        }
        return k / (max + 1 / m) + 1;//由上面逻辑保证了在1到m之间且各数生成概率相等
    }

    public static int rand() {
        return new Random().nextInt();
    }

}
