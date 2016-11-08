package com.practice.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class QueueingProblem {
	
	static class Struct{
		int startPoint;
		int endPoint;
		int queueLen;
		
		public Struct(int startPoint, int endPoint, int queueLen) {
			// TODO Auto-generated constructor stub
			this.startPoint = startPoint;
			this.endPoint = endPoint;
			this.queueLen = queueLen;
		}
		
	}
	
	static class StructComparator implements Comparator<Struct>{
		
		@Override
		public int compare(Struct o1, Struct o2) {
			// TODO Auto-generated method stub
			if(o1.endPoint<o2.endPoint){
				return 1;
			}
			else if(o1.endPoint>o2.endPoint){
				return -1;
			}
			else{
				if(o1.startPoint<o2.startPoint){
					return 1;
				}
				else{
					return -1;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, ArrayList<Struct>> testData = new LinkedHashMap<Integer, ArrayList<Struct>>();
		Struct s1 = new Struct(1, 5, 9);
		Struct s2 = new Struct(7, 5, 5);
		Struct s3 = new Struct(3, 6, 1);
		Struct s4 = new Struct(4, 6, 3);
		Struct s5 = new Struct(5, 7, 7);
		Struct s6 = new Struct(6, 7, 1);
		ArrayList<Struct> l = new ArrayList<>();
		l.add(s1);
		l.add(s2);
		l.add(s3);
		l.add(s4);
		l.add(s5);
		l.add(s6);
		Collections.sort(l, new StructComparator());
		boolean isWait = true;
		while(isWait){
			
		}
	}

}
