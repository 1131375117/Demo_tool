package com.hua.algorithm.rec;

/**
 * 斐波那契数列
 *
 * @author fuhua
 **/
public class Fibonacci {

    //1 1 2 3 5 8 13 21

    /**
     * 分析一段代码好坏？时间复杂度和空间复杂度？如何优化？
     *
     * @param n
     * @return
     */
    public static int fib(int n) {//时间复杂度(2^n)--优化-->O(N) OR O(nlogn)
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ":" + fib(i));
        }

    }
}
