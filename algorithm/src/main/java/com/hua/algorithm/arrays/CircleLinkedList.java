package com.hua.algorithm.arrays;

/**
 * 循环链表
 *
 * @author fuhua
 **/
public class CircleLinkedList<T> {
    Node head;
    T t;
    int size;

    /**
     * 循环链表add
     *
     * @param t value
     */
    public void add(T t) {
        Node node = new Node(t);
        if (head == null) {
            head = node;
            head.next = head;
            size++;
            return;
        }
        Node curr = head;
        for (int i = 1; i < size; i++) {
            curr = curr.next;
        }
        curr.next = node;
        node.next = head;
        size++;
    }

    /**
     * 循环链表查找
     */
    public void show() {
        if (head == null) {
            System.out.println("暂无元素");
        }
        Node curr = head;
        for (int i = 0; i < size; i++) {
            System.out.println("链表中存在的剩余元素:" + curr.data);
            curr = curr.next;
        }
    }


    /**
     * 循环链表删除
     */
    public void delete(int index) {
        if (head == null) {
            System.out.println("暂无元素可删除");
            return;
        }
        if (index == 0) {
            head = null;
        }
        Node curr = head;
        for (int i = 1; i < index; i++) {
            curr = head.next;
        }
        curr.next=curr.next.next;
        size--;
    }


    class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        CircleLinkedList<Integer> circleLinkedList=new CircleLinkedList<Integer>();
        circleLinkedList.add(1);
        circleLinkedList.add(2);
        circleLinkedList.add(3);
        circleLinkedList.add(4);
        circleLinkedList.add(5);
        circleLinkedList.delete(2);
        circleLinkedList.show();
    }
}
