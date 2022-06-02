package com.hua.algorithm.leecode;

/**
 * @author fuhua
 **/
public class Leecode_25 {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next=l2;
        ListNode l3 = new ListNode(3);
        l2.next=l3;
        ListNode l4 = new ListNode(4);
        l3.next=l4;
        l4.next=new ListNode(5);
        System.out.println( reverseKGroup(l1,2));
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        //首先遍历出链表的长度
        //创建一个临时的避免分情况讨论
        ListNode dump=new ListNode(0);
        //首节点
        dump.next=head;
        ListNode pre=dump;
        //pre代表前一个节点
        while(head!=null){
            ListNode right=pre;
            ListNode start=pre;
            //查询剩余部分是否大于k
            for (int i = 0; i < k; i++) {
                right= right.next;
                if(right==null){
                    return dump.next;
                }
            }
            ListNode end= right.next;
            ListNode left=start.next;

            start.next=null;
            right.next=null;

            reversList(left);

            left.next=end;
            start.next=right;

            pre=left;
            head=left.next;
        }
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
