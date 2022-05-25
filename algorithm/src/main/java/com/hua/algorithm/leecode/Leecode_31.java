package com.hua.algorithm.leecode;

import java.util.Arrays;

/**
 * @author fuhua
 **/
public class Leecode_31 {
    public static void main(String[] args) {
        nextPermutation( new int[] {1,1});
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length - 2;
        while (n >= 0 && nums[n] >= nums[n + 1]) {
            n--;
        }
        if (n >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[n] >= nums[j]) {
                j--;
            }
            swap(nums, n, j);
        }
        reverse(nums,n+1);
        System.out.println(Arrays.toString(nums));
    }

    private static void reverse(int[] nums, int start) {
        int left=start,right=nums.length-1;
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int n, int j) {
        int temp = nums[n];
        nums[n] = nums[j];
        nums[j] = temp;
    }
}
