package com.practice.main;

public class MinNoOfCoins {
	static int minCoins(int coins[], int m, int V)
	{
	    // table[i] will be storing the minimum number of coins
	    // required for i value.  So table[V] will have result
	    int table[] = new int[V+1];
	 
	    // Base case (If given value V is 0)
	    table[0] = 0;
	 
	    // Initialize all table values as Infinite
	    for (int i=1; i<=V; i++)
	        table[i] = Integer.MAX_VALUE;
	 
	    // Compute minimum coins required for all
	    // values from 1 to V
	    for (int i=1; i<=V; i++)
	    {
	        // Go through all coins smaller than i
	        for (int j=0; j<m; j++)
	          if (coins[j] <= i)
	          {
	              int sub_res = table[i-coins[j]];
	              if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
	                  table[i] = sub_res + 1;
	          }
	    }
	    return table[V];
	}
	
	// Recursive Solution to find minimum number of coins
    public static int getMinCoins(int[] values, int sum) {
        if(sum == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < values.length; i++) {
            if(sum >= values[i])
                min = Math.min(min, getMinCoins(values, sum-values[i]));
        }
        return min + 1;
    }
 
    // DP Solution to find minimum number of coins
    public static int getMinCoinsDP(int[] values, int sum) {
        int min = 0;
        int[] minCoins = new int[sum+1];        
        minCoins[0] = 0;
        for(int i = 1; i <= sum; i++) {
            min = Integer.MAX_VALUE;
            for(int j = 0; j < values.length; j++) {
                if(i >= values[j])
                    min = Math.min(min, minCoins[i - values[j]]);
            }
            if(min != Integer.MAX_VALUE)
                minCoins[i] = min + 1;
            else
                minCoins[i] = Integer.MAX_VALUE;
        }
        return minCoins[sum];
    }
	
	public static void main(String arg[]) {
		int coins[] = {9,6,5,1};
		int V=11;
		System.out.println(minCoins(coins, coins.length, V));
	}
}
