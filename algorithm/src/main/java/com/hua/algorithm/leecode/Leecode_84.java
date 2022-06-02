package com.hua.algorithm.leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author fuhua
 **/
public class Leecode_84 {
    /*基于单调栈+哨兵的实现*/
    public static int largestRectangleAreaWithSentinel(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int result = 0;

        int[] heightsWithSentinel = new int[len + 2];
        /*头哨兵，不会大于输入数组里任何一个元素，它肯定不会出栈，因此栈一定不会为空*/
        heightsWithSentinel[0] = 0;
        System.arraycopy(heights, 0, heightsWithSentinel, 1, len);
        /*尾哨兵，它不会大于输入数组里任何一个元素，
        它会让所有输入数组里的元素出栈（头边的哨兵元素除外）*/
        heightsWithSentinel[len + 1] = 0;
        len += 2;
        heights = heightsWithSentinel;

        Deque<Integer> stack = new LinkedList<Integer>();
        /*先放入头哨兵，在循环里就不用做非空判断*/
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                result = Math.max(result, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return result;
    }

    //
    /*基于单调栈+哨兵的实现*/
    public static int largestRectangleAreaWithSentinel1(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int result = 0;
        int sentinel[] = new int[heights.length + 2];
        //数组拷贝
        System.arraycopy(heights, 0, sentinel, 1, len);

        //新建一个栈
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(0);
        for (int i = 1; i < sentinel.length; i++) {
            while (sentinel[i] < sentinel[stack.peek()]) {
                int n = stack.pop();
                int h = sentinel[n];
                int w = i - stack.peek()-1;
                result = Math.max(result, h * w);
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1,2};
        System.out.println(largestRectangleAreaWithSentinel1(nums));
    }
}
