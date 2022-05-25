package com.hua.algorithm.sort.test;

import java.util.Arrays;

/**
 * @author fuhua
 * 手撕堆排序
 **/
public class HeapSort {
    public static void main(String[] args) {
        int data[] = {1, 5, 3, 4, 5, 6, 4, 1};
        heapSort(data);
        System.out.println(Arrays.toString(data));
    }

    /**
     * 堆排序
     *
     * @param data
     */
    public static void heapSort(int data[]) {
        int len = data.length;
        //最后一个子树节点
        int n = data.length / 2 - 1;
        for (int i = n; i >= 0; i--) {
            //建造堆
            buildHeap(data, i, len);
        }
        //查找
        for (int i = len - 1; i >= 0; i--) {
            if (data[i] < data[0]) {
                int temp = data[i];
                data[i] = data[0];
                data[0] = temp;
                buildHeap(data, 0, i);
            }
        }

    }

    /**
     * 建造堆
     *
     * @param data 数据
     * @param start 开始的地方
     * @param end   结束的地方
     */
    public static void buildHeap(int[] data, int start, int end) {
        int parent = start;
        int left = parent * 2 + 1;

        while (left < end) {
            int temp = left;
            int right = left + 1;
            if (right < end && data[left] < data[right]) {
                temp = right;
            }
            if (data[parent] > data[temp]) return;
            else {
                int t = data[parent];
                data[parent] = data[temp];
                data[temp] = t;
                parent = temp;
                left = parent * 2 + 1;
            }
        }

    }
}
