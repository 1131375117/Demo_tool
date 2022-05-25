package com.hua.algorithm.leecode;

import com.hua.algorithm.sort.QuickSort;

import java.util.Arrays;

/**
 * @author fuhua
 **/
public class Leecode_215 {
    public static void main(String[] args) {
        int arr[] = new int[]{2,1};
        int k = 1;
        System.out.println(findKthLargest(arr, k));

    }

    public static int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length - k];
    }
    /**
     * 快排
     * 核心思路：1）找准基准数
     * 2)从右往左找比基准数小的数
     * 3）从左往右找比基准数大的数
     */
    private static void quickSort(int[] nums, int left, int right) {
        int base = nums[left];
        //int base = (int) (left + Math.random() * (right - left + 1));
        int ll = left;
        int rr = right;
        while (ll < rr) {
            while (ll < rr && base <= nums[rr]) {
                rr--;
            }
            if (ll < rr) {
                int temp = nums[ll];
                nums[ll] = nums[rr];
                nums[rr] = temp;
                ll++;
            }

            while (ll < rr && base >= nums[ll]) {
                ll++;
            }
            if (ll < rr) {
                int temp = nums[ll];
                nums[ll] = nums[rr];
                nums[rr] = temp;
                rr--;
            }

            if (left < ll) {
                quickSort(nums, left, ll - 1);
            }
            if (ll < right) {
                quickSort(nums, ll + 1, right);
            }

        }

    }

}
