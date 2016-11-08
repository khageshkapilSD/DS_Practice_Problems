package com.practice.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MergeLinkedList {
	static Nodee head1, temp1, current1;
	static Nodee head2, temp2, current2;
	
	public static void main(String args[]) {
		Scanner sc;
		sc = new Scanner(System.in);
		for(int i=0;i<5;i++){
			temp1 = new Nodee(sc.nextInt());
			temp2 = new Nodee(sc.nextInt());
			if(i==0){
				head1 = temp1;
				head2 = temp2;
			}
			else{
				if(i==1){
					head1.next = temp1;
					head2.next = temp2;
				}
				else{
					current1.next = temp1;
					current2.next = temp2;
				}
			}
			current1 = temp1;
			current2 = temp2;
		}
		current1 = head1;
		current2 = head2;
		
		/*while(current1!=null){
			System.out.println(current1.data);
			current1 = current1.next;
		}
		
		while(current2!=null){
			System.out.println(current2.data);
			current2 = current2.next;
		}*/
		System.out.println("+++++++++++++++++++++");
		List<Integer> set = new ArrayList<Integer>();
		while(current1!=null&&current2!=null){
			set.add(current1.data);
			set.add(current2.data);
			set.add(current1.data+current2.data);
			current1 = current1.next;
			current2 = current2.next;
		}
		System.out.println("+++++++++++++++++++++");
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		
	}
}

class Nodee{
	int data;
	Nodee next;
	
	Nodee(int data){
		this.data = data;
		this.next = null;
	}
}
