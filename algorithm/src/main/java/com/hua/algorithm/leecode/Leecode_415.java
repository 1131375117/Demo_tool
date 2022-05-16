package com.hua.algorithm.leecode;

import java.util.Stack;

/**
 * @author fuhua
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Leecode_415 {

    public static String addStrings(String num1, String num2) {
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0||n!=0; i--, j--) {
            int a = i < 0 ? 0 : num1.charAt(i) - '0';
            int b = j < 0 ? 0 : num2.charAt(j) - '0';
            stringBuffer.append((a + b + n) % 10);
            n = (a + b + n) / 10;
        }
        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(addStrings("11", "123"));

    }
}
