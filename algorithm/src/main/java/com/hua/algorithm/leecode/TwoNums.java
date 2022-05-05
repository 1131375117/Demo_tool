package com.hua.algorithm.leecode;

import java.util.ArrayList;

/**
 * 两数之和 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，
 * 并返回它们的数组下标。  你可以假设每种输入只会对应一个答案。
 * 但是，数组中同一个元素在答案里不能重复出现。  你可以按任意顺序返回答案。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuhua
 **/
public class TwoNums {
    public static void main(String[] args) {

    }

    /**
     * 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                res[0] = list.indexOf(nums[i]);
                res[1] = i;
            }
            list.add(target - nums[i]);
        }
        return res;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
