package com.hua.algorithm.leecode;

import java.util.ArrayList;

/**
 * 两数相加
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class AddTwonumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //定义一个变量存储相加的结果
        int carry = 0;
        ListNode p, dummy = new ListNode(0);
        p = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry % 10);
            carry /= 10;
            p = p.next;

        }
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode next = new ListNode(4);
        l1.next= next;
        l1.next.next=new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode next1 = new ListNode(6);
        l2.next= next1;
        l2.next.next=new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);


    }

}

class ListNode {
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
