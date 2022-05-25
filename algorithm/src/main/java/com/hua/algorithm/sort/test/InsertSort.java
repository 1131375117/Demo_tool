package com.hua.algorithm.sort.test;

import java.util.Arrays;

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
    public static void main(String[] args) {
        int data[] = new int[]{4, 5, 6, 3, 2, 1};
        insertSort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void insertSort(int data[]) {
        int len = data.length;
        for (int i = 1; i <= len-1; i++) {
            int num=data[i];
            int j = i-1;
            for (; j >=0; j--) {
                if(data[j]>num){
                    data[j+1]=data[j];
                }else{
                    break;
                }
            }
         data[j+1]=num;
        }

    }
}

