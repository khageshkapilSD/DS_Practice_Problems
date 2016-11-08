package com.practice.main;

public class ReverseWords {
	public static void main(String args[]) {
		String str = "India is great country";
		reverseWords(str);
		System.out.println();
		reverseWordLettters(str);
	}
	
	private static void reverseWords(String str) {
		char[] temp=str.toCharArray();
		int t=temp.length-1;
		for(int i=t;i>=0;i--){
			char d=temp[i];
			if(d==' '){
				for(int j=i+1;j<=t;j++,t--){
					char x=temp[j];
					temp[j]=temp[t];
					temp[t]=x;
				}
				t=i-1;
			}
			else if(i==0){
				for(int j=i;j<=t;j++,t--){
					char x=temp[j];
					temp[j]=temp[t];
					temp[t]=x;
				}
			}
		}
		
		for(int j=0,i=temp.length-1;i>=j;j++,i--){
			char x=temp[j];
			temp[j]=temp[i];
			temp[i]=x;
		}
		
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i]);
		}
	}

	private static void reverseWordLettters(String str) {
		char[] temp=str.toCharArray();
		int t=temp.length-1;
		for(int i=t;i>=0;i--){
			char d=temp[i];
			if(d==' '){
				for(int j=i+1;j<=t;j++,t--){
					char x=temp[j];
					temp[j]=temp[t];
					temp[t]=x;
				}
				t=i-1;
			}
			else if(i==0){
				for(int j=i;j<=t;j++,t--){
					char x=temp[j];
					temp[j]=temp[t];
					temp[t]=x;
				}
			}
		}
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i]);
		}
	}
}
