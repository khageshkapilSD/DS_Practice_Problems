package com.practice.main.importantInterviewQuestion;

public class CheckArrayAnySumZero {
	
	/*
	 * Find if there  exists a pair of no. in the input array such that their sum is Zero(0)
	 * Note : The array input is arranged in the ascending order
	 */
	
	boolean checkIfAnySumIsZero(int[] arr) {
		int arrLen = arr.length;
		for(int i=0;i<arrLen;i++) {
			int j=i;
			int zeroSumNumber = 0;
			
			if(arr[i]<0) {
				zeroSumNumber = Math.abs(arr[i]);
				while( j<arrLen && arr[j]<=zeroSumNumber) {
					if(arr[j]==zeroSumNumber)
						return true;
					j++;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		CheckArrayAnySumZero ca = new CheckArrayAnySumZero();
		
		int[] arr = {-5,-2,0,1,2,3,4};
		System.out.println(ca.checkIfAnySumIsZero(arr));
	}

}
