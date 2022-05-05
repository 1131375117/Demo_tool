package com.hua.algorithm.leecode;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leecode_283 {
    public void moveZeroes(int[] nums) {
        //解法思路，双指针
        if(nums.length == 0){
            return;
        }
        int poi=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[poi++]=nums[i];
            }
        }

        for (int i = poi+1; i < nums.length; i++) {
                nums[i]=0;
        }
    }
}
