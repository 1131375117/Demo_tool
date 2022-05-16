package com.hua.algorithm.leecode;

import com.hua.tulingxueyuan.stackandqueue.DecodeString.DecodeString_394_UseList;

import java.util.Stack;

/**
 * @author fuhua
 **/
public class Leecode_394 {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {

            char curr = s.charAt(idx);
            //判断是否是数字
            if (Character.isDigit(curr)) {
                StringBuffer num = new StringBuffer();
                while (Character.isDigit(s.charAt(idx))) {
                    num.append(s.charAt(idx++));
                }
                countStack.push(Integer.parseInt(num.toString()));
            }

            //判断括号
            else if ('[' == curr) {
                stringStack.push(res);
                res = "";
                idx++;
            } else if (']' == curr) {
                //获取字符串
                //处理括号之间的数据
                StringBuffer temp = new StringBuffer(stringStack.pop());

                Integer num = countStack.pop();
                for (Integer i = 0; i < num; i++) {
                    temp.append(res);
                }
                res += temp.toString();
                idx++;
            } else {
                //处理普通字符
                res += s.charAt(idx++);
            }

        }
    return res;

}

    public static void main(String[] args) {
        System.out.println(new Leecode_394().decodeString("3[a2[c]]"));
    }
}
