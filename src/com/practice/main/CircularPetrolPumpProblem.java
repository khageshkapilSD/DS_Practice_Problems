package com.practice.main;

import java.util.Scanner;
public class CircularPetrolPumpProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int p[]={4,6,7,4};
		int d[]={6,5,3,5};
		
		int size=0;
		int end=p.length-1,start=0;
		int tank=0;
		
		int i=start;
		
		while(i!=end)
		{
			if(p[i]+tank>=d[i])
			{
				tank=p[i]-d[i]+tank;
			}
			else
			{
				tank=0;
				start=(i+1)%p.length;
				
				if(start==0)
					end=p.length-1;
				else
					end=start-1;
			}
			i=(++i)%p.length;
		}
		
		System.out.println("start = "+start);
		
	}

}
