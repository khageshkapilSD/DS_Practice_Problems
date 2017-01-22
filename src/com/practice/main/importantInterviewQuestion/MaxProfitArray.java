package com.practice.main.importantInterviewQuestion;

public class MaxProfitArray {
	
	/*
	 * Find max profit from the array of the prices of stock, where 
	 * indexes denote the no. of minutes past 9:30 AM
	 * NOTE: 1. The buying  price should be lesser in index in the array than
	 *          the selling price
	 *       2. you cannot BUY and SELL at the same time
	 */
	int getMaxProfit(int[] stockPrices) {
		
		if(stockPrices==null || stockPrices.length<2)
			return 0;
		
		int max = 0, min = 0, minIndex = 0, maxIndex = 0;
		int[] minValues, minIndices;
		
		int stocks = stockPrices.length;
		
		minValues = new int[stocks];
		minIndices = new int[stocks];
		int itr = -1;
		
		for(int i=0;i<stocks;i++) {
			if(i==0) {
				min = max = stockPrices[i];
				minIndex = maxIndex = i;
			}
			
			if(stockPrices[i] > max) {
				max = stockPrices[i];
				maxIndex = i;
				if(itr!=-1 && minIndices[itr]<maxIndex && minValues[itr]<min) {
					min = minValues[itr];
					minIndex = minIndices[itr];
				}
			}
			if(stockPrices[i] < min) {
				if(i<maxIndex) {
					min = stockPrices[i];
					minIndex = i;
				}
				else {
					++itr;
					minValues[itr] = stockPrices[i];
					minIndices[itr] = i;
				}
			}
		}
		
		return max-min;
	}
	
	public static void main(String[] args){ 
		MaxProfitArray mpa = new MaxProfitArray();
		int[] stockPricesArray = {10,7,11,8,5,9,12,3};
		System.out.println(mpa.getMaxProfit(stockPricesArray));
	}

}
