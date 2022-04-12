package com.hua.algorithm.stack;

/**
 * @author fuhua
 **/
public class ArrayStack<T> implements MyStack<T> {

    //设置初始大小
    private T[] a = (T[]) new Object[1];
    //大小，初始元素的个数
    private int n = 0;

    @Override
    public MyStack<T> push(T t) {//时间复杂度O(1)
        JudgeSize();
        a[n++] = t;
        return null;
    }

    public void JudgeSize() {
        if (n >= a.length) {
            resize(2 * a.length);
        } else if (n > 0 && n <= a.length / 2) {
            resize(a.length / 2);
        }
    }

    private void resize(int size) {
        T[] temp = (T[]) new Object[size];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    @Override
    public T pop() {//出栈
        if (isEmpty()) {
            return null;
        }
        T t = a[--n];
        a[n] = null;
        return t;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {

        return n == 0;
    }
}
