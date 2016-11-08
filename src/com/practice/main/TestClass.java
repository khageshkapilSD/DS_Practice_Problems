package com.practice.main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/

public class TestClass {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        Map<String, Integer> mapPrice = new HashMap<String, Integer>();
        Map<String, Integer> mapInventory = new HashMap<String, Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
        	line = br.readLine();
            String prod = line.substring(0, line.indexOf(" "));
            String price = line.substring(line.indexOf(" ")+1);
            mapPrice.put(prod, Integer.parseInt(price));
        }
        line = br.readLine();
        N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
        	line = br.readLine();
        	String temp = line.substring(line.indexOf(" ")+1);
        	if(line.startsWith("+")){
        		if(mapPrice.containsKey(temp)){
        			if(mapInventory.containsKey(temp)){
        				mapInventory.put(temp, mapInventory.get(temp)+1);
        			}
        			else{
        				mapInventory.put(temp, 1);
        			}
        		}
        	}
        	else if(line.startsWith("-")){
        		if(mapPrice.containsKey(temp)){
        			if(mapInventory.containsKey(temp)){
        				mapInventory.put(temp, mapInventory.get(temp)-1);
        			}
        		}
        	}
        	else if(line.startsWith("?")){
        		if(Integer.parseInt(temp)==0){
        			ans.add(mapInventory.size());
        		}
        		else{
        			Set<String> mapKeys = mapPrice.keySet();
        			int j = 0;
        			for (String string : mapKeys) {
						if(mapInventory.containsKey(string)&&mapPrice.get(string)>Integer.parseInt(temp)){
							j++;
						}
					}
        			ans.add(j);
        		}
        	}
        }
        for (Integer integer : ans) {
			System.out.println(integer);
		}
    }
}
