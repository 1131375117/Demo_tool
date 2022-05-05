package com.hua.algorithm.leecode;

import java.util.ArrayList;

/**
 * @author fuhua
 * <p>
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Leecode_83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == p.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }


    public ListNode deleteDuplicates2(ListNode head) {
        ListNode p = head;
        if (p == null) {
            return head;
        }
        if(p.next==null){
            return head;
        }
        head.next=deleteDuplicates2(p.next);
        return head.val==head.next.val?head.next:head;
    }

}
