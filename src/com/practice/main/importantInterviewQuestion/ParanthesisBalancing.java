package com.practice.main.importantInterviewQuestion;

public class ParanthesisBalancing {
	
	//With Recurssion
	int checkBalance(int score, int index, String hostString) {
		if(hostString.isEmpty())
			return 0;
		if(hostString.startsWith(")") || score<0)
			return -1;
		if(hostString.endsWith("("))
			return 1;
		
		if(index>=hostString.length())
			return score;
		if(hostString.charAt(index)=='(')
			score = checkBalance(score+1,index+1,hostString);
		else if(hostString.charAt(index)==')')
			score = checkBalance(score-1,index+1,hostString);
		return score;
	}

	//Normally
	boolean checkBalance(String hostString) {
		if(hostString.isEmpty() || hostString.startsWith(")") 
				|| hostString.endsWith("("))
			return false;
		int openCount = 0, closeCount = 0;
		boolean isBalanced = true;
		for(int i=0;i<hostString.length();i++) {
			if(hostString.charAt(i)=='(')
				openCount++;
			else if(hostString.charAt(i)==')')
				closeCount++;
			if(closeCount>openCount) {
				isBalanced = false;
				break;
			}
			
		}
		return isBalanced;
	}
	
	public static void main(String[] args) {
		ParanthesisBalancing pb = new ParanthesisBalancing();
		
		String bracketString = "((())))(()";
		System.out.println(pb.checkBalance(0,0,bracketString));
		System.out.println(pb.checkBalance(bracketString));
		
		String bracketString1 = ")(())))(()";
		System.out.println(pb.checkBalance(0,0,bracketString));
		System.out.println(pb.checkBalance(bracketString1));
		
		String bracketString2 = "(())))(()(";
		System.out.println(pb.checkBalance(0,0,bracketString2));
		System.out.println(pb.checkBalance(bracketString2));
		
		String bracketString3 = "(())()(())";
		System.out.println(pb.checkBalance(0,0,bracketString3));
		System.out.println(pb.checkBalance(bracketString3));
	}
}
