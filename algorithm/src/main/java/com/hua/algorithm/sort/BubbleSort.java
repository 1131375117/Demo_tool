package com.hua.algorithm.sort;

import com.hua.tulingxueyuan.sort.PrintArray;

/**
 * 冒泡排序 核心思想是交换
 */
public class BubbleSort {
    public static int[] sort(int[] nums) {
        //循环的次数，从第零个元素开始，依次和后面的比较
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        PrintArray.print(PrintArray.SRC);
        System.out.println("============================================");
        int[] dest = BubbleSort.sort(PrintArray.SRC);
        PrintArray.print(dest);
    }
}
