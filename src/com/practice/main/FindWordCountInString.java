package com.practice.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindWordCountInString {
	public static void main(String args[]){
		/*String in = "i have a male cat. the color of male cat is Black";
		int i = 0;
		Pattern p = Pattern.compile("male cat");
		Matcher m = p.matcher( in );
		while (m.find()) {
		    i++;
		}
		System.out.println(i);*/
		
		String str = "helloslkhellodjladfjhello";
		String findStr = "hello";
		int lastIndex = 0;
		int count = 0;

		while(lastIndex != -1){

		    lastIndex = str.indexOf(findStr,lastIndex);

		    if(lastIndex != -1){
		        count ++;
		        lastIndex += findStr.length();
		    }
		}
		System.out.println(count);
	}
}
