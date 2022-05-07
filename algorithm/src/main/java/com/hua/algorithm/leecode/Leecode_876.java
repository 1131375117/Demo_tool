package com.hua.algorithm.leecode;

/**
 * @author fuhua
 **/
public class Leecode_876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode last = head;
        ListNode slow = head;
        while (last != null && last.next != null) {
            last = last.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode next = new ListNode(2);
        listNode.next = next;
        ListNode next1 = new ListNode(3);
        next.next=next1;
        //next1.next = new ListNode(4);
        Leecode_876 leecode_876 = new Leecode_876();
        ListNode node = leecode_876.middleNode(listNode);
        System.out.println(node);
    }

}
