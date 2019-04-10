package com.learn.demo.design.spring.pattern.structural.adapter.stack;

// Õ»½Ó¿Ú
public interface IStack<T> {
	public boolean isEmpty();
	
	public T pop() throws StackException;
	
	public T peek() throws StackException;
	
	public void push(T e) throws StackException;
	
	public void clear();
}
