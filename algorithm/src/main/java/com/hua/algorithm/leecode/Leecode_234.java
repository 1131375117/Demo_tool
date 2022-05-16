package com.hua.algorithm.leecode;

/**
 * @author fuhua
 * Given the head of a singly linked list, return true if it is a palindrome.
 * <p>
 * 整个流程可以分为以下五个步骤：
 * <p>
 * 找到前半部分链表的尾节点。
 * 反转后半部分链表。
 * 判断是否回文。
 * 恢复链表。
 * 返回结果。
 **/
public class Leecode_234 {
    /**
     * 解题方法:快慢指针
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode p = head;
        ListNode middleNode = getMiddleNode(p);
        ListNode reverseList = reverseList(middleNode);
        while (reverseList != null) {
            if (reverseList.val != head.val) {
                return false;
            }
            reverseList = reverseList.next;
            head = head.next;
        }
        return true;
    }


    public ListNode getMiddleNode(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.next;
    }

    public ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode curr=node;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode next = new ListNode(2);
        listNode.next = next;
        ListNode next1 = new ListNode(2);
        next.next=next1;
        next1.next = new ListNode(1);
        Leecode_234 leecode_234 = new Leecode_234();
        boolean palindrome = leecode_234.isPalindrome(listNode);
        System.out.println(palindrome);

    }
}
