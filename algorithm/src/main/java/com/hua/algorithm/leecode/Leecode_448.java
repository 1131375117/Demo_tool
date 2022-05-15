package com.hua.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 448. Find All Numbers Disappeared in an Array
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [2]
 */
public class Leecode_448 {
    class Solution {

        public List<Integer> findDisappearedNumbers(int[] nums)  {
            int n = nums.length;
            for (int i = 0; i < nums.length; i++) {
                int x=(nums[i]-1)%n;
                nums[x]+=n;
            }

            List<Integer> ret = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (nums[i] >n) {
                    ret.add(i + 1);
                }
            }
            return ret;
        }
    }



}
