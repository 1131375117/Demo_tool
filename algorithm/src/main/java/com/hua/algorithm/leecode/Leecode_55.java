package com.hua.algorithm.leecode;

/**
 * @author fuhua
 *
 * 跳跃游戏--解题思路--贪心算法
 **/
public class Leecode_55 {
    public static void main(String[] args) {
        boolean b = canJump(new int[]{0, 0, 1, 8, 1});
        System.out.println(b);
    }
    public static boolean canJump(int[] nums) {
        int n= nums.length;
        int maxDistance=0;
        for (int i = 0; i < n; i++) {
            if(i<=maxDistance){
                maxDistance= Math.max(maxDistance,i+nums[i]);
            }
            if(maxDistance>=n-1){
                return true;
            }
        }
      return false;
    }
}
