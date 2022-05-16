package com.hua.tulingxueyuan.string;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ：Mark老师
 * @description ：(LeetCode-20) 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，
 * 判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class ValidParentheses_20 {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
