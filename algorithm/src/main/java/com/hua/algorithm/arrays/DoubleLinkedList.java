package com.hua.algorithm.arrays;

import java.util.NoSuchElementException;

/**
 * 双向链表
 *
 * @author fuhua
 **/
public class DoubleLinkedList<T> {
    Node head;
    Node tail;

    /**
     * 从头部插入
     *
     * @param t
     */
    public void insertHead(T t) {
        Node newNode = new Node(t);
        if (head == null) {
            tail = newNode;
        } else {
            head.pre = newNode;
            newNode.next = head;
        }
        head = newNode;
    }

    /**
     * 从头部删除
     */
    public void deleteHead() {
        if (head == null) {
            throw new NullPointerException();
        }
        //代表就一个节点
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            //获取第二个
            head = head.next;
            head.pre = null;
        }
    }

    /**
     * 根据data删除
     */
    public void deleteKey(T data) {
        Node curr = head;
        while (curr.data != data) {
            if (curr.next == null) {
                throw new NoSuchElementException();
            }
            curr = curr.next;
        }
        if (curr == head) {// 指向下个就表示删除第一个
            deleteHead();
        } else {
            curr.pre.next = curr.next;
            if (curr == tail) {//删除的是尾部
                tail = curr.pre;
                curr.pre.next = null;
            } else {
                curr.next.pre = curr.pre;
            }
        }

    }

    public void add() {

    }

    class Node {
        T data;
        Node pre;
        Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    public DoubleLinkedList() {
    }
}
