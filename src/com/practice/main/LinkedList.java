package com.practice.main;

import java.util.Stack;

public class LinkedList<NodeType> {

	static class Node{
		
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	Node head = null;
	
	private void reverseLinkedList() {
		if(head==null){
			System.out.println("Empty List");
		}
		else {
			Node first = null, next;
			
			while(head!=null){
				next = head.next;
				head.next = first;
				first = head;
				head = next;
			}
			head = first;
		}
		System.out.println();
	}
	
	private void insertNode(int data) {
		if(this.head==null){
			Node headNode = new Node(data);
			this.head = headNode;
		}
		else{
			Node headNode = new Node(data);
			headNode.next = head;
			head = headNode;
		}
	}
	
	private void printList() {
		Node temHead = head;
		
		while (temHead!=null) {
			System.out.print(temHead.data+"->");
			temHead = temHead.next;
		}
		System.out.println("NULL");
	}
	
	private boolean isPalindrome() {
		
		Node slow = head;
		Node fast = head.next;
		Node endOfFirstHalf;
		Node startOfSecondHalf;
		Node startOfFirstHalf;
		
		while (fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast==null){
			endOfFirstHalf = slow;
		}
		else{
			endOfFirstHalf = slow.next;
		}
		
		startOfSecondHalf = slow.next;
		Stack<Node> stack = new Stack<>();
		
		while (startOfSecondHalf!=null) {
			stack.push(startOfSecondHalf);
		}
		
		startOfFirstHalf = head;
		
		while (startOfFirstHalf.next!=endOfFirstHalf) {
			
			if(startOfFirstHalf.data != stack.pop().data){
				return false;
			}
			startOfFirstHalf = startOfFirstHalf.next;
//			startOfSecondHalf = startOfSecondHalf.next;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		LinkedList<Node> linkedList = new LinkedList<Node>();
		linkedList.insertNode(1);
		linkedList.insertNode(2);
		linkedList.insertNode(3);
		linkedList.insertNode(2);
		linkedList.insertNode(1);
//		linkedList.insertNode(5);
//		linkedList.insertNode(6);
//		linkedList.insertNode(7);
//		linkedList.insertNode(8);
		linkedList.printList();
		linkedList.reverseLinkedList();
		linkedList.printList();
		System.out.println(linkedList.isPalindrome());
	}

}
