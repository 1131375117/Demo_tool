package com.hua.tulingxueyuan.tulingxueyuan.bit;

/**
 * @author ：Mark老师
 * @description ：(LeetCode-338) 比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，
 * 计算其二进制表示中 1 的个数 ，
 * 返回一个长度为 n + 1 的数组 ans 作为答案。
 */
public class CountingBits_338 {

    /*利用X &= (X - 1)清除最低位的1的功能来解决*/
    public int[] countBits(int num) {
        int[] bits = new int[num+1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i&(i-1)] + 1;
        }
        return bits;
    }

    /*利用奇偶性解决*/
    public int[] countBits2(int num) {
        int[] bits = new int[num+1];
        bits[0] = 0;
        for(int i = 1; i <= num; i++)
        {
            bits[i] = ((i&1) == 1 ?  bits[i-1]+1 : bits[i>>1]);
        }
        return bits;
    }
}
