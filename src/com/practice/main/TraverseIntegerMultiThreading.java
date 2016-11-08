package com.practice.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TraverseIntegerMultiThreading {
	
	private static final Object LOCK = new Object(); 
	
	static ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 2, 10, 3, 23, 2, 32,1, 2, 10, 3, 23, 2, 32,1, 2, 10, 3, 23, 2, 32));
	
	public static void main(String[] args) {		
//		ArrayBlockingQueue<Runnable> bolck = new ArrayBlockingQueue<>(5);
		
		ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 5, 1000, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(5));
		
		Iterator<Integer> itr = arr.iterator();
		while (itr.hasNext()) {
			pool.execute(new MyR(""+itr.next()));
		}
		pool.shutdown();
	}
	
	public static void run(String num) {
		// TODO Auto-generated method stub
		synchronized (LOCK) {
			System.out.println(Thread.currentThread().getName()+" :: "+num);
		}
	}
	
	private static class MyR implements Runnable {
		
		private String name;
		public MyR(String name){
			this.name = name;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (arr) {
				System.out.println(Thread.currentThread().getName()+" :: "+name);
			}
		}
	};
}
