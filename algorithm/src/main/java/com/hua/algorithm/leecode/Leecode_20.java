package com.hua.algorithm.leecode;

import java.util.Stack;

/**
 * @author fuhua
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Leecode_20 {

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < chars.length; i++) {
            if (')' == chars[i]) {
                if (stack.isEmpty() || '(' != stack.pop()) {
                    return false;
                }
                continue;
            } else if ('}' == chars[i]) {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
                continue;
            } else if (']' == chars[i]) {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
                continue;
            }
            stack.push(chars[i]);
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean valid = isValid("}{");
        System.out.println(valid);
    }
}
