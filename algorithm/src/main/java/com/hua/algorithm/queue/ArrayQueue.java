package com.hua.algorithm.queue;

/**
 * 队列
 *
 * @author fuhua
 **/
public class ArrayQueue {
    /**
     * 数据
     */
    int data[];
    /**
     * 队列头
     */
    int head = 0;
    /**
     * 队列尾
     */
    int tail = 0;
    /**
     * 队列容量
     */
    int n = 0;

    public ArrayQueue(int cap) {
        this.data = new int[cap];
    }

    /**
     * 入队
     */

    public void push(int m) {
        if (isFull()) {
            return;
        }
        data[tail] = m;
        tail++;
    }

    /**
     * 出队
     */
    public int pup() {//存在很大的空间浪费,前面的空间用过一次就不再使用了?解决方法？--在push没有空间的时候统一移动一次
        if (isEmpty()) {
            throw new NullPointerException();
        }
        int m = data[head];
        head++;
        return m;
    }

    /**
     * 判断队列是否满了
     */
    public boolean isFull() {
        if (tail == n) {
            return true;
        }
        return false;
    }

    /**
     * 判断队列是否为空
     *
     * @return true代表该队列暂无数据，false反之则可以进行pop操作
     */
    public boolean isEmpty() {
        if (head == tail) {
            return true;
        }
        return false;
    }
}
