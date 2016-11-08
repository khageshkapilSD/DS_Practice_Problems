package com.practice.main;

class MinHeap {
	int capacity;
	int arr[];
	int size;
 
	public MinHeap(int capacity) {
		this.capacity = capacity;
		arr = new int[this.capacity];
		this.size = 0;
	}
 
	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
 
	int parent(int i) {
		return (i-1)/2;
	}
 
	int left(int i) {
		return 2*i + 1;
	}
 
	int right(int i) {
		return 2*i + 2;
	}
 
	int getMin() {
		if(size <= 0) {
			System.out.println("Heap underflow");
			return Integer.MAX_VALUE;
		}
		return arr[0];
	}
 
	int extractMin() {
		if(size <= 0) {
			System.out.println("Heap underflow");
			return Integer.MAX_VALUE;
		}
		if(size == 1) {
			size--;
			return arr[0];
		}
 
		int root = arr[0];
		arr[0] = arr[size-1];
		size--;
		minHeapify(0);
 
		return root;
	}
 
	void minHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;
 
		if(l < size && arr[l] < arr[smallest])
			smallest = l;
		if(r < size && arr[r] < arr[smallest])
			smallest = r;
 
		if(smallest != i) {
			swap(arr,i,smallest);
			minHeapify(smallest);
		}
	}
 
	void fixUpwards(int i) {
		while(i != 0 && arr[i] < arr[parent(i)]) {
			swap(arr,i,parent(i));
			i = parent(i);
		}
	}
 
	void decreaseKey(int i, int newKey) {
		arr[i] = newKey;
		fixUpwards(i); 
	}
 
	void insert(int key) {
		if(size == capacity) {
			System.out.println("Heap overflow");
			return;
		}
 
		arr[size++] = key;
		fixUpwards(size-1);
	}
 
	void delete(int i) {
		decreaseKey(i,Integer.MIN_VALUE);
		extractMin();
	}
 
	void printMinHeap() {
		for(int i=0;i<size;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
 
public class BaseMinHeap {
	public static void main(String[] args) {
		MinHeap mh = new MinHeap(5);
 
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
