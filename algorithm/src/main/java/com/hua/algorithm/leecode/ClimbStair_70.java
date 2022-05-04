package com.hua.algorithm.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *  
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClimbStair_70 {
    private Map<Integer,Integer> storeMap=new HashMap<>();
    //爬楼梯
    public int climbStairs1(int n) {
        //1.递归思想
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(storeMap.get(n)==null){
            int result=climbStairs1(n-1)+climbStairs1(n-2);
            storeMap.put(n,result);
        }
        return storeMap.get(n);
    }

    /**
     * 循环思想
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int result=0;
        int pre=2;
        int prepre=1;
        for (int i = 3; i <=n ; i++) {
            result=pre+prepre;
            prepre=pre;
            pre=result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStair_70().climbStairs2(5));

    }
}
