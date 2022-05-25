package com.hua.algorithm.sort.test;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author fuhua
 **/
public class MergeSort {

    public static void main(String[] args) {
        int data[] = new int[]{4, 5, 6, 3, 2, 1};
        mergeSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    /**
     * 归并排序核心思想，分而治之
     *
     * @param data 需要排序的数据
     */
    private static void mergeSort(int[] data, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);
            merge(data, left, mid, right);
        }
    }

    private static void merge(int[] data, int left, int mid, int right) {
        int temp[] = new int[data.length];
        int point1 = left;
        int point2 = mid + 1;
        int loc = left;
        while (point1 <= mid && point2 <= right) {
            if (data[point1] < data[point2]) {
                temp[loc] = data[point1];
                point1++;
            } else {
                temp[loc] = data[point2];
                point2++;
            }
            loc++;
        }
        while (point1 <= mid) {
            temp[loc] = data[point1];
            loc++;
            point1++;
        }
        while (point2 <= right) {
            temp[loc] = data[point2];
            loc++;
            point2++;
        }
        for (int i = left; i <=right; i++) {
            data[i] = temp[i];
        }

    }
}
