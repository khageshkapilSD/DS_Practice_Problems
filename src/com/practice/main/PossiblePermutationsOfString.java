package com.practice.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.print.attribute.Size2DSyntax;

public class PossiblePermutationsOfString {
	/*public List<String> permuteString(String s) {
		 
	    List<String> stringPermutations = new ArrayList<>(); 
	    if (s == null || s.length() == 0) {
	        return null;
	    } else if (s.length() == 1) {
	        stringPermutations.add(s);
	        return stringPermutations;
	    } else { 
	        // Any character can be left out from the string
	        // For simplicity, leaving out the first character
	        char c = s.charAt(0); 
	        List<String> postfixPermutations = permuteString(s.substring(1));
	        for (String sub : postfixPermutations) {
	            for (int position = 0 ; position < sub.length() + 1; position++) {
	                String prefix = sub.substring(0,position);
	                String postfix = sub.substring(position, sub.length());  
	                String permutedString = prefix + c + postfix; 
	                stringPermutations.add(permutedString); 
	            }
	        }   
	    }
	    return stringPermutations;
	}*/
	
	public List<String> permuteStringIterative(String s) {
	    List<String> stringPermutations = new ArrayList<>();
	    // initial permutation is a single character
	    stringPermutations.add(s.substring(0,1)); 
	    for ( int pointer = 1; pointer < s.length(); pointer ++) {
	        char toInsert = s.charAt(pointer);
	        List<String> newPermutations = new ArrayList<>(); 
	        for (String previousPermutation: stringPermutations) {
	            for (int j = 0 ; j < previousPermutation.length() +1 ; j++) {
	                String newString = previousPermutation.substring(0,j) 
	                        + toInsert + previousPermutation.substring(j);
	                newPermutations.add(newString);
	            }
	        } 
	        stringPermutations = newPermutations;
	    }
	    return stringPermutations;
	}
	
	/*public Set<String> permuteStringIterative(String s) {
		Set<String> results = new HashSet<String>();
		if(s==null||s.isEmpty()){
			return null;
		}
		else if (s.length()==1) {
			results.add(s);
			return results;
		}
		else{
			char firstChar = s.charAt(0);
			Set<String> temp = permuteStringIterative(s.substring(1));
			for (String string : temp) {
				for(int i=0;i<string.length()+1;i++){
					String newString1 = string.substring(0, i);
					String newString2 = string.substring(i);
					String newString = newString1 + firstChar + newString2;
					results.add(newString);
				}
			}
			temp.clear();
		}
		return results;
	}*/
	
	public static void main(String[] str){
		PossiblePermutationsOfString permutationsOfString = new PossiblePermutationsOfString();
		List<String> possiblePermutations = permutationsOfString.permuteStringIterative("ABC");
		for (String string : possiblePermutations) {
			System.out.println(string);
		}				
		System.out.println(">>"+possiblePermutations.size());
	}
}
