package com.practice.main;

/**
 * Date 09/22/2014
 * @author tusroy
 * 
 * Do pattern matching using KMP algorithm
 * 
 * Runtime complexity - O(m + n) where m is length of text and n is length of pattern
 * Space complexity - O(n)
 */
public class KMP_PatternMatching {
    
    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     */
    private int[] computeTemporaryArray(char pattern[]){
        int [] lps = new int[pattern.length];
        int index =0;
        for(int i=1; i < pattern.length;i++){
            if(pattern[i] == pattern[index]){
                lps[i] = index + 1;
                index++;
            }else{
                if(index != 0){
                    index = lps[lps[index-1]];
                    --i;
                }else{
                    lps[i]=0;
                }
            }
        }
        return lps;
    }
    
    /**
     * KMP algorithm of pattern matching.
     */
    public boolean KMP(char []text, char []pattern){
        
        int lps[] = computeTemporaryArray(pattern);
        int i=0;
        int j=0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        if(j == pattern.length){
            return true;
        }
        return false;
    }
        
    public static void main(String args[]){
        
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        KMP_PatternMatching ss = new KMP_PatternMatching();
        boolean result = ss.KMP(str.toCharArray(), subString.toCharArray());
        System.out.print(result);
        
    }
}