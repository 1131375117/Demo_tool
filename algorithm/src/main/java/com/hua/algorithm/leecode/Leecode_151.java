package com.hua.algorithm.leecode;

import java.util.ArrayDeque;

/**
 * @author fuhua
 * <p>
 * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Leecode_151 {
    public static void main(String[] args) {
        String the_sky_is_blue = new Leecode_151().reverseWords("a good   example");
        System.out.println(the_sky_is_blue);
    }

    public String reverseWords(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        while (left <= right) {
            if (s.charAt(left) == ' '&&word.length()!=0) {
                stack.addFirst(word.toString());
                word.setLength(0);

            } else if(' '!=s.charAt(left)){
                word.append(s.charAt(left));
            }
            left++;
        }
        stack.addFirst(word.toString());
        return String.join(" ", stack);
    }
}
