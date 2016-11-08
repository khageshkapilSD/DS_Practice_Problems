package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M[][]={{1,2,3},{4,5,0},{1,0,3},{1,3,4}};
//		int N[][] = new int[M.length][];
//		N = M;
		Set<Integer> row = new HashSet<>();
		Set<Integer> col = new HashSet<>();
		for (int i = 0; i < M.length; i++) {
			for(int j=0;j<M[i].length;j++){
				if(M[i][j]==0){
					row.add(i);
					col.add(j);
				}
			}
		}
		
		opp(M,row,col);
		
		
		for(int r=0;r<M.length;r++){
			for(int c=0;c<M[r].length;c++){
				System.out.print(M[r][c]);
			}
			System.out.println();
		}
		
	}
	
	public static void opp(int[][] N, Set<Integer> row, Set<Integer> col) {
		for(int i=0;i<N.length;i++){
			for (int c : col) {
				N[i][c] = 0;
			}
			if(row.contains(i))
			for(int j=0;j<N[i].length;j++){
				N[i][j]=0;
			}
		}
		
		for(int r=0;r<N.length;r++){
			for(int c=0;c<N[r].length;c++){
				System.out.print(N[r][c]);
			}
			System.out.println();
		}
		System.out.println("**********");
	}
}
