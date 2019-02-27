package com.learn.demo.algorithm;

/**
 * 汉诺塔问题：
 * 输入一个正整数n，表示有n个盘片在第一根柱子上。输出操作序列，
 * 格式为“移动 t从 x 到 y”。每个操作一行，表示把x柱子上的编号为t的盘片挪到柱子y上。
 * 柱子编号为A，B，C，你要用最少的操作把所有的盘子从A柱子上转移到C柱子上。
 */
public class Hanio {
    public static void main(String[] args) {
        int i = 3;
        char a = 'A', b = 'B', c = 'C';
        hanio(i, a, b, c);
    }

    public static void hanio(int n, char a, char b, char c) {
        if (n == 1)
            System.out.println("移动" + n + "号盘子从" + a + "到" + c);
        else {
            hanio(n - 1, a, c, b);//把上面n-1个盘子从a借助b搬到c
            System.out.println("移动" + n + "号盘子从" + a + "到" + c);//紧接着直接把n搬动c
            hanio(n - 1, b, a, c);//再把b上的n-1个盘子借助a搬到c
        }
    }
}