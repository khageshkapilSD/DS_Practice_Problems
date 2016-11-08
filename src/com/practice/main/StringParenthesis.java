package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StringParenthesis {
	static ArrayList<Character> chars = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String in = br.readLine();
			char[] str = in.toCharArray();
			int i=0, j=str.length-1;
			/*for(int i=str.length-1;i>=0;i++){
				char ch = str[i];
				if((ch>=48&&ch<=65)||(ch>=97&&ch<=122)){
					chars.add(in.charAt(i));
				}
			}
			for(int i=0;i<in.length();i++){
				char ch = in.charAt(i);
				if((ch>=48&&ch<=65)||(ch>=97&&ch<=122)){
					in.chars.add(in.charAt(i));
				}
			}*/
			while(i<j){
				while(!isChar(str[i])){
					i++;
				}
				while(!isChar(str[j])){
					j--;
				}
				char temp = str[i];
				str[i] = str[j];
				str[j] = temp;
				i++;
				j--;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static boolean isChar(char ch) {
		if((ch>=48&&ch<=65)||(ch>=97&&ch<=122)){
			return true;
		}
		return false;
	}

}
