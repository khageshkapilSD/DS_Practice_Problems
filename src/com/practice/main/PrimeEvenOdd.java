package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrimeEvenOdd {
	public static void main(String args[]) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String inp = br.readLine();
			char[] arr= inp.toCharArray();
			ArrayList<Integer> prime = new ArrayList<>();
			ArrayList<Integer> even = new ArrayList<>();
			ArrayList<Integer> odd = new ArrayList<>();
			for(int i=2;i<arr.length-3;i++){
				if(isPrime(arr[i]))
					prime.add(arr[i]-48);
				else if(isEven(arr[i]))
					even.add(arr[i]-48);
				else if(isOdd(arr[i]))
					odd.add(arr[i]-48);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
