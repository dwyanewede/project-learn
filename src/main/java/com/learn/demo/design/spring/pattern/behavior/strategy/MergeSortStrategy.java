package com.learn.demo.design.spring.pattern.behavior.strategy;

import java.util.List;

// ConcreteStrategy
public class MergeSortStrategy implements SortingStrategy {

	@Override
	public void sort(List<Integer> list) {
		System.out.println("Sorting List using merge sort");
	}

}
