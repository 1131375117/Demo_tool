package com.hua.algorithm.leecode;

/**
 * @author fuhua
 * <p>
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 **/
public class Offer_22 {
    //解法思路-->双指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null||head.next==null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = k; i > 0; i--) {
            if (slow == null) {
                return fast;
            }
            slow = slow.next;
        }

        while (slow != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode next = new ListNode(2);
        listNode.next = next;
/*        ListNode next1 = new ListNode(3);
        next.next = next1;
        next1.next = new ListNode(4);*/
        Offer_22 offer_22 = new Offer_22();
        ListNode kthFromEnd = offer_22.getKthFromEnd(listNode, 1);

        System.out.println(kthFromEnd);
    }
}
