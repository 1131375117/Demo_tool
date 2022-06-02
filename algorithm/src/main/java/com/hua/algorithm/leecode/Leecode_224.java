package com.hua.algorithm.leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author fuhua
 **/
public class Leecode_224 {
    public static void main(String[] args) {
        //todo 待做
    }

    public static int calculate(String s) {

        char[] chars = s.toCharArray();
        Deque<Integer> stack = new LinkedList<>();
        Deque<Character> characters = new LinkedList<>();
        int nums = 0;
        for (int i = 0; i < chars.length; i++) {
            if (" ".equals(s)) {
                continue;
            }

            if (chars[i] == '(') {
                characters.push(chars[i]);
            }
            if ('0' < chars[i] && chars[i] < '9') {
                nums = nums * 10 + chars[i] - '0';
                if (i < chars.length - 1 && '0' < chars[i + 1] && chars[i + 1] < '9') {
                    continue;
                }
            }
            if(chars[i]=='+'||chars[i]=='-'){

            }

        }
return 0;

    }
}
