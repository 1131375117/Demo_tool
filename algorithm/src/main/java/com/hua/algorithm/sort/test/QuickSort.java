package com.hua.algorithm.sort.test;

/**
 * 什么是快速排序？
 * 1）找基准数
 * 2）从右往左找比基准数小的数
 * 3）从左往右找比基准数大的数
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr[] = new int[]{4,4,3,2,4,4};
        qSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void qSort(int data[], int left, int right) {
        int base = data[left];//表示基准数
        int ll = left;//表示从左向右的数
        int rr = right;//表示从右向左的数
        while (ll < rr) {

            while (ll < rr && data[rr] >= base) {
                rr--;
            }
            if (ll < rr) {
                int temp = data[rr];
                data[rr] = data[ll];
                data[ll] = temp;
                ll++;
            }

            while (ll < rr && data[ll] <= base) {
                ll++;
            }
            if (ll < rr) {
                int temp = data[ll];
                data[ll] = data[rr];
                data[rr] = temp;
                rr--;
            }
            if(left<ll){
                qSort(data, left, ll - 1);
            }
            if(ll<right){
                qSort(data, ll + 1, right);
            }


        }

    }
}
