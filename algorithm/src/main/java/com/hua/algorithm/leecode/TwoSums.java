package com.hua.algorithm.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class TwoSums {
    Map<Integer,Integer> store=new HashMap<>();
    public int[] twoSum(int[] nums, int target) {
       int result[]=new int[2];
        for ( int i=0;i<nums.length;i++){
            int other=target-nums[i];
            if(store.containsKey(other)){
                result[0]=store.get(other);
                result[1]=i;
                return result;
            }else{
                store.put(nums[i], i);
            }

        }
        return result;
    }
}