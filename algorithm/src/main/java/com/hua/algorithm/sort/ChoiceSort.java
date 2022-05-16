package com.hua.algorithm.sort;

import com.hua.tulingxueyuan.sort.PrintArray;

/**
 * 选择排序
 *
 * 核心思想:
 *  从第一个数字开始依次和后面的数比较，找出最小的或者做大的放在第一个，交换
 *
 * @author fuhua
 **/
public class ChoiceSort {
    public static int[] choiceSort(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    //找到最小的元素下标
                    index = j;
                }
            }
            System.out.println("最小的数为:" + nums[index]);
             swap(nums, index, i);
        }
        return nums;
    }

    private static void swap(int[] nums, int min, int i) {
        int temp = nums[i];
        nums[i] = nums[min];
        nums[min] = temp;
    }


    public static void main(String[] args) {
        PrintArray.print(PrintArray.SRC);
        System.out.println("============================================");
        int[] dest = ChoiceSort.choiceSort(PrintArray.SRC);
        PrintArray.print(dest);
    }
}
