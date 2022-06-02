package com.hua.algorithm.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author fuhua
 *
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Leecode_739 {
    public static void main(String[] args) {
     int nums[]=new int[] {30,40,50,60};
        System.out.println(Arrays.toString(dailyTemperatures2(nums)));
    }
    public static int[] dailyTemperatures(int[] temperatures) {

        //返回的具体温度结果
        int[] counts = new int[temperatures.length];

        for (int i = 0; i <= temperatures.length-1; i++) {
            for (int j = i+1; j <= temperatures.length-1; j++) {
                if(temperatures[i]<temperatures[j]){
                    counts[i]=j-i;
                    break;
                }
            }
        }
        return counts;
    }

    //单调栈
    public static int[] dailyTemperatures1(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 单调栈
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack=new LinkedList<>();
        for (int i = 0; i < length; i++) {
            while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                int num=stack.pop();
                ans[num]=i-num;
            }
            stack.push(i);
        }
        return ans;
    }

}
