package com.hua.algorithm.arrays;

/**
 * 单链表
 *
 * @author hua-cloud
 */
public class SingleList<T> {
    private int size;
    private Node head;

    public SingleList() {

    }

    /**
     * 链表插入指定位置
     */
    public void add(T t, int index) {
        if (index > size || index < 0) {
            throw new ArithmeticException();
        }
        if (head == null) {
            addFirst(t);
            return;
        }
        Node curr = head;
        for (int i = 1; i < index; i++) {
            curr = curr.next;
        }
        Node newNode = new Node(t);
        newNode.next = curr.next;
        curr.next = newNode;
        this.size++;
    }

    /**
     * 插入尾部
     *
     * @param t 插入元素
     */
    public void add(T t) {

        if (head == null) {
            addFirst(t);
            return;
        }
        Node curr = head;
        for (int i = 1; i < size; i++) {
            curr = curr.next;
        }
        Node newNode = new Node(t);
        curr.next = newNode;
        this.size++;
    }

    /**
     * 插入头部
     */
    public void addFirst(T t) {
        head = new Node(t);
        size++;
    }

    /**
     * 删除头节点
     */
    public void deleteHead() {
        head = head.next;
        size--;

    }

    /**
     * 删除指定位置的元素
     */
    public void delete(int index) {
        if (head == null) {
            throw new NullPointerException();
        }
        if (index == 0) {
            deleteHead();
        }
        Node curr = head;
        for (int i = 1; i < index; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        size--;
    }

    /**
     * 元素的遍历
     */
    public T get(int index) {
        if (head == null) {
            throw new NullPointerException();
        }
        if (index == 0) {
            return head.data;
        }
        Node curr = head;
        for (int i = 1; i <= index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    /**
     * 获取size
     */
    public int size() {
        return size;
    }


    class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    @Override
    public String toString() {
        StringBuffer tostring = new StringBuffer();
        tostring.append("[");
        Node node = head;
        while (node != null) {
            tostring.append(node.data);
            node = node.next;
            if (node != null) {
                tostring.append(",");
            }
        }
        StringBuffer append = tostring.append("]");
        return append.toString();
    }

    public static void main(String[] args) {
        SingleList<Integer> singleList = new SingleList<Integer>();
        singleList.addFirst(1);
        singleList.add(2);
        singleList.add(3);
        System.out.println(singleList.size());
        System.out.println(singleList);
        System.out.println(singleList.get(1));
    }
}
