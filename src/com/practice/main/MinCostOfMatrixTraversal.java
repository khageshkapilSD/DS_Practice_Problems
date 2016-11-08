package com.practice.main;

public class MinCostOfMatrixTraversal{
	static final int R=3, C=3;
	static int tc[][];
	public static void main(String[] args) {
		int cost[][] = { {1, 2, 3},{4, 8, 2},{1, 5, 3}};
		System.out.println(minCost(cost, 2, 2));
	}
	
	static int minCost(int cost[][], int m, int n)
	{
	     int i, j;  
	     tc = new int[R][C];
	     tc[0][0] = cost[0][0];
	 
	     /* Initialize first column of total cost(tc) array */
	     for (i = 1; i<= m; i++)
	        tc[i][0] = tc[i-1][0] + cost[i][0];
	 
	     /* Initialize first row of tc array */
	     for (j = 1; j <=n; j++)
	        tc[0][j] = tc[0][j-1] + cost[0][j];
	 
	     /* Construct rest of the tc array */
	     for (i = 1; i <=m; i++)
	        for (j = 1; j <=n; j++)
	            tc[i][j] = min(tc[i-1][j-1], tc[i-1][j], tc[i][j-1]) + cost[i][j];
	 
	     return tc[m][n];
	}
	 
	/* A utility function that returns minimum of 3 integers */
	static int min(int x, int y, int z)
	{
	   if (x < y)
	      return (x < z)? x : z;
	   else
	      return (y < z)? y : z;
	}

}
