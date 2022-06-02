package com.hua.algorithm.leecode;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fuhua
 **/
public class Leecode_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode pre = dump;
        //第一步，找到left前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        //第二步，找到right节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        //截取出一个子链表
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        //第三步，切断链表
        pre.next = null;
        rightNode.next = null;

        //链表反转
        linkListReverse(leftNode);
        //拼接链表
        pre.next = rightNode;
        leftNode.next = curr;

        return dump.next;
    }

    private void linkListReverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            //当前链表的下一个节点，为了不改变旋转中链表的结构
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
    }

    //反转链表二
    public static ListNode reverseBetween1(ListNode head, int left, int right) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode pre = dump;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode start = pre;
        ListNode leftNode = pre.next;
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        //切断链表
        ListNode end = rightNode.next;
        rightNode.next = null;
        start.next = null;
        //反转链表
        reversList(leftNode);
        leftNode.next = end;
        start.next = rightNode;
        return dump.next;
    }

    public static void reversList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
    }
}
