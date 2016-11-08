package problems;

import java.util.ArrayList;
import java.util.Scanner;

public class Party_Knowledge {
	
	public static void main(String args[]) {
		int[][] matrix;
		String[] knowledge;
		Scanner s = new Scanner(System.in);
		ArrayList<String> input;
		try {
			input = new ArrayList<String>();
			String line = "";
			while ((line = s.nextLine()).length() > 0) {
				input.add(line);
			}
		}
		finally {
			s.close();
		}
		
		try {
			int N = Integer.parseInt(input.get(0).substring(0, input.get(0).indexOf(" ")));
			int M = Integer.parseInt(input.get(0).substring(input.get(0).indexOf(" ")+1));
			if(N>=1&&N<=100000&&M>=0&&M<=100000){
				matrix = new int[N][N];
				knowledge = input.get(1).split(" ");
				for(int i=0;i<M;i++){
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
