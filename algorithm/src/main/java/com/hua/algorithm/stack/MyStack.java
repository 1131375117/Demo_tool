package com.hua.algorithm.stack;

public interface MyStack<T> {

	MyStack<T> push(T t);		//入栈
	
	T pop();	//出栈
	
	int size();		// 大小
	
	boolean isEmpty();
}
