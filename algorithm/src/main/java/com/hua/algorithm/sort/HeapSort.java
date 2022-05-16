package com.hua.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int data[] = {1, 5, 3, 4, 5, 6, 4, 1};
        heapSort(data);
        System.out.println(Arrays.toString(data));
    }
    //建造堆
    public static void buildMaxHeap(int data[],int start,int end){
        int paren=start;
        int left=paren*2+1;
        while(left<end){
            int temp=left;
            int right=left+1;
            if(right<end&&data[left]<data[right]){
                temp=right;
            }
            if(data[paren]>data[temp])return;
            else{
                int n=data[paren];
                data[paren]=data[temp];
                data[temp]=n;
                paren=temp;
                left=paren*2+1;
            }
        }

    }

    public static void heapSort(int data[]){
        int len=data.length;
        for (int i = len/2-1; i >=0 ; i--) {
            buildMaxHeap(data,i,len);
        }
        for (int i = len-1; i >=0 ; i--) {
            if(data[i]<data[0]){
                int temp=data[i];
                data[i]=data[0];
                data[0]=temp;
                buildMaxHeap(data,0,i);
            }
        }
    }

/*    public static void maxHeap(int data[], int start, int end) {//建一个大顶堆,start表示从哪个地方开始，end结束
        int parent = start;
        int left = parent * 2 + 1;
        while (left < end) {
            int temp = left;
            //比较左右父节点的大小
            int right = left + 1;
            if (right < end && data[left] < data[right]) {
                temp=right;//就要换右节点
            }
            if(data[parent]>data[temp])return;
            else{
                //交换
                int t=data[parent];
                data[parent]=data[temp];
                data[temp]=t;
                parent=temp;
                left=parent*2+1;//继续堆化
            }
        }

    }

    public static void heapSort(int data[]) {
        int len = data.length;

        for (int i = len / 2 - 1; i >= 0; i--) {
            maxHeap(data, i, len);
        }
        for (int i = len - 1; i >= 0; i--) {
            if (data[0] > data[i]) {
                int temp = data[0];
                data[0] = data[i];
                data[i] = temp;
                maxHeap(data, 0, i);
            }
        }
    }*/


}
