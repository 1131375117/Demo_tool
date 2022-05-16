package com.hua.algorithm.sort;

/**
 * 插入排序
 * ① 从第一个元素开始，该元素可以认为已经被排序
 * ② 取出下一个元素，在已经排序的元素序列中从后向前扫描
 * ③如果该元素（已排序）大于新元素，将该元素移到下一位置
 * ④ 重复步骤③，直到找到已排序的元素小于或者等于新元素的位置
 * ⑤将新元素插入到该位置后
 * ⑥ 重复步骤②~⑤
 *
 * @author fuhua
 **/
public class InsertSort {
    public static int[] insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //int temp = i;
            for (int j = i - 1; j >= 0; j--) {
                if(nums[i]>nums[j]){
                    nums[j+1]=nums[i];
                }
        }

    }
        return nums;
}


}
