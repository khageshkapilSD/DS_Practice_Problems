package com.practice.main;

import com.practice.main.dataStructuresImpl.MinHeapByArray;

public class BaseMinHeap {
	public static void main(String[] args) {
		MinHeapByArray mh = new MinHeapByArray(5);

		mh.insert(3);
		mh.printMinHeap();
		System.out.println();
 
		mh.insert(2);
		mh.printMinHeap();
		System.out.println();
 
		mh.delete(1);
		mh.printMinHeap();
		System.out.println();
 
		mh.insert(15);
		mh.printMinHeap();
		System.out.println();
 
		mh.insert(5);
		mh.printMinHeap();
		System.out.println();
 
		mh.insert(4);
		mh.printMinHeap();
		System.out.println();
 
		mh.insert(45);
		mh.printMinHeap();
		System.out.println();
 
		mh.insert(50);
		mh.printMinHeap();
		System.out.println();
 
		System.out.println("Extracted min: " + mh.extractMin());
		mh.printMinHeap();
		System.out.println();
 
		System.out.println("Min: " + mh.getMin());
		mh.printMinHeap();
		System.out.println();
 
		mh.decreaseKey(2,1);
		mh.printMinHeap();
		System.out.println();
 
		System.out.println("Min: " + mh.getMin());
		mh.printMinHeap();
	}
}
