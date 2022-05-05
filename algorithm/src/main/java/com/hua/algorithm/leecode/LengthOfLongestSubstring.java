package com.hua.algorithm.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int l = 0;
        int r = 0;
        List<Character> list = new ArrayList<>();
        while (r != s.length()) {
            if (!list.contains(s.charAt(r))) {
                list.add(s.charAt(r));
                res = Math.max(r - l + 1, res);
                r++;
            } else {
                list.remove(0);
                l++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}
