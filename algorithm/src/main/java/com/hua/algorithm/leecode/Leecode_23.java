package com.hua.algorithm.leecode;

/**
 * @author fuhua
 **/
public class Leecode_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        int mid=(start+end)/2;
        if(start==end){
            return lists[start];
        }
        if(start>end){
            return null;
        }
       return mergeTwoList(merge(lists,start,mid),merge(lists,mid+1,end));
    }

    private ListNode mergeTwoList(ListNode left, ListNode right) {
        ListNode listNode=new ListNode(0);
        ListNode p=listNode;
        while(left!=null&&right!=null){
            if(left.val<right.val){
                p.next=left;
                left=left.next;
            }else{
                p.next=right;
                right=right.next;
            }
            p=p.next;
        }

        if(left!=null){
            p.next=left;
        }
        if(right!=null){
            p.next=right;
        }
        return listNode.next;
    }

}
