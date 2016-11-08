package com.practice.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NearestPrimeNumber {
	static ArrayList<Integer> prime = new ArrayList<>();
	public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for(int i=1;i<=N;i++){
        	if(isNum(i)){
        		prime.add(i);
        	}
        }
        line = br.readLine();
        String[] in = line.split(" ");
        for (int i=0;i<N;i++) {
			int num = Integer.parseInt(in[i]);
			int end = prime.size();
			int op=-1;
			if(num>=prime.get(end-1))
				op = prime.get(end-1);
			else if(num<=prime.get(0))
				op = prime.get(0);
			else
				op = nearestSafeStreet(0, end-1, num);
			if(i==0){
				System.out.print(op);
			}
			else{
				System.out.print(" "+op);
			}
		}
    }
	
	private static boolean isNum(int n) {
		boolean isPrime = true;
		if(n==0||n==1){
			return false;
		}
		int limit = (int)Math.sqrt(n);
		for(int i=2;i<=limit;i++){
			if(n%i==0){
				return false;
			}
		}
		return isPrime;
	}
	
	private static int nearestSafeStreet(int start, Integer end, int n) {
		int mid = start + (end - start)/2;
		int midN = prime.get(mid);
		int midNPlus = prime.get(mid+1);
		if(midN==n||(n>midN&&n<midNPlus))
			return midN;
		else if(n>midN)
			return nearestSafeStreet(mid+1, end, n);
		else
			return nearestSafeStreet(start, mid-1, n);
	}
}
