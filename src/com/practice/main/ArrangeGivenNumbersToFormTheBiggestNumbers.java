package com.practice.main;

import java.util.Arrays;
import java.util.Comparator;
 
/*
 * A simple solution that comes to our mind is to sort all numbers in descending order, 
 * but simply sorting doesn’t work. For example, 548 is greater than 60, but in output 60 comes before 548. 
 * As a second example, 98 is greater than 9, but 9 comes before 98 in output.
 * So how do we go about it? The idea is to use any comparison based sorting algorithm. 
 * In the used sorting algorithm, instead of using the default comparison, 
 * write a comparison function myCompare() and use it to sort numbers. 
 * Given two numbers X and Y, how should myCompare() decide which number to put first – 
 * we compare two numbers XY (Y appended at the end of X) and YX (X appended at the end of Y). 
 * If XY is larger, then X should come before Y in output, else Y should come before. 
 * For example, let X and Y be 542 and 60. To compare X and Y, we compare 54260 and 60542.
 * Since 60542 is greater than 54260, we put Y first.
 */

class MyComparator implements Comparator<Integer> {
	public int compare(Integer a, Integer b) {
		Integer choice1 = Integer.valueOf(a.toString() + b.toString());
		Integer choice2 = Integer.valueOf(b.toString() + a.toString());
		return choice1.compareTo(choice2);
	}
}
 
public class ArrangeGivenNumbersToFormTheBiggestNumbers {
 
	static int[] arrangeGivenNumbersToFormTheBiggestNumbers(int[] arr) {
		int n = arr.length;
 
		Integer[] arr1 = new Integer[n];
 
		for(int i=0;i<n;i++)
			arr1[i] = arr[i];
 
		Arrays.sort(arr1,new MyComparator());
 
		for(int i=0;i<n;i++)
			arr[i] = arr1[n-1-i];
 
		return arr;
	}
 
	static void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
 
	public static void main(String[] args) {
		int[] arr = {548, 60, 54, 546};
		printArray(arr);
		arrangeGivenNumbersToFormTheBiggestNumbers(arr);
		printArray(arr);
	}
}
