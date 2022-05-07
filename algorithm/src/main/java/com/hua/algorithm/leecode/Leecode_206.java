package com.hua.algorithm.leecode;

/**
 * @author fuhua
 **/
public class Leecode_206 {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        if (head == null) {
            return null;
        }
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
