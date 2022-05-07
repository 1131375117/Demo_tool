package com.hua.algorithm.leecode;

/**
 * @author fuhua
 **/
public class Leecode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        if (headA == null || headB == null) {
            return null;
        }
        while (l1 != l2) {
            l1 = (l1 != null ? l1.next : headB);
            l2 = (l2 != null ? l2.next : headA);
        }
        return l1;
    }
}
