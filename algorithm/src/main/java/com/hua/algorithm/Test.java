package com.hua.algorithm;

import com.hua.algorithm.arrays.SingleList;

/**
 * @author fuhua
 **/
public class Test {
    public static void main(String[] args) {
        SingleList<Integer> singleList =new SingleList<Integer>();
        singleList.addFirst(1);
        singleList.add(2);
        singleList.add(3);
        System.out.println(singleList.size());
        System.out.println(singleList);
        System.out.println(singleList.get(1));

    }
}
