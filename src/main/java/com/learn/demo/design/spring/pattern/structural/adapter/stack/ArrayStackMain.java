package com.learn.demo.design.spring.pattern.structural.adapter.stack;

public class ArrayStackMain {

	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<Integer>(6);
		
		try {
			for(int i = 0; i < 6; i++) {
				stack.push(i);
			}
			
			System.err.println(stack);
			
			for(int i = 0; i < 5; i++) {
				stack.pop();
				System.out.println(stack);
			}
			
		} catch(StackException e) {
			System.err.println(e);
		}

	}

}
