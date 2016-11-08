package com.practice.main;

/*Q: Given an n x n matrix, where every row and column is sorted in increasing order. 
Given a number x, how to decide whether this x is in the matrix. 
The designed algorithm should have linear time complexity.*/

/*Algo: 1) Start with top right element
	    2) Loop: compare this element e with x
   		  i) if they are equal then return its position
   		  ii) e < x then move it to down (if out of bound of matrix then break return false) 
   		  iii) e > x then move it to left (if out of bound of matrix then break return false)
	    3) repeat the i), ii) and iii) till you find element or returned false*/

/*Complexity : Time Complexity: O(n)
The above approach will also work for m x n matrix (not only for n x n). Complexity would be O(m + n)*/

public class FindingNumberInSortedMatrix {
	static int search(int mat[][], int n, int x)
	{
	   int i = 0, j = n-1;  //set indexes for top right element
	   while ( i < n && j >= 0 )
	   {
	      if ( mat[i][j] == x )
	      {
	         System.out.println("Found at "+i+","+j);
	         return 1;
	      }
	      if ( mat[i][j] > x )
	        j--;
	      else //  if mat[i][j] < x
	        i++;
	   }
	 
	   System.out.println("Element not found");
	   return 0;  // if ( i==n || j== -1 )
	}
	 
	// driver program to test above function
	public static void main(String[] arg)
	{
	  int mat[][] = { {10, 20, 30, 40},
	                  {15, 25, 35, 45},
	                  {27, 29, 37, 48},
	                  {32, 33, 39, 50},
	                };
	  search(mat, mat.length, 29);
	}
}
