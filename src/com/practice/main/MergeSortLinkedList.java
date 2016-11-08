package com.practice.main;

public class MergeSortLinkedList {
	
	static class Node{
		int data;
		Node next;
		
		public Node(int key){
			data = key;
			next = null;
		}

		public Node getNext() {
			return this.next;
		}
		
		public int getData() {
			return this.data;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
	}

	Node startNode;

	public static void main(String[] args) {
		new MergeSortLinkedList();
	}

	public MergeSortLinkedList() {
		Node node1 = new Node(10);
		Node node2 = new Node(1);
		Node node3 = new Node(-2);
		Node node4 = new Node(8);
		Node node5 = new Node(9);
		Node node6 = new Node(10);
		Node node7 = new Node(1);

		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);

		startNode = node1;

		Node sortedStartNode = mergeSortLinkList(startNode);
		printLinkList(sortedStartNode);
	}

	private Node mergeSortLinkList(Node startNode) {

		// Break the list until list is null or only 1 element is present in
		// List.
		if (startNode == null || startNode.getNext() == null) {
			return startNode;
		}

		// Break the linklist into 2 list.
		// Finding Middle node and then breaking the Linled list in 2 parts.
		// Now 2 list are, 1st list from start to middle and 2nd list from
		// middle+1 to last.

		Node middle = getMiddle(startNode);
		Node nextOfMiddle = middle.getNext();
		middle.setNext(null);

		// Again breaking the List until there is only 1 element in each list.
		Node left = mergeSortLinkList(startNode);
		Node right = mergeSortLinkList(nextOfMiddle);

		// Once complete list is divided and contains only single element,
		// Start merging left and right half by sorting them and passing Sorted
		// list further.
		Node sortedList = mergeTwoListRecursive(left, right);

		return sortedList;
	}

	// Recursive Approach for Merging Two Sorted List
	private Node mergeTwoListRecursive(Node leftStart, Node rightStart) {
		if (leftStart == null)
			return rightStart;

		if (rightStart == null)
			return leftStart;

		Node temp = null;

		if (leftStart.getData() < rightStart.getData()) {
			temp = leftStart;
			temp.setNext(mergeTwoListRecursive(leftStart.getNext(), rightStart));
		} else {
			temp = rightStart;
			temp.setNext(mergeTwoListRecursive(leftStart, rightStart.getNext()));
		}
		return temp;
	}

	private Node getMiddle(Node startNode) {
		if (startNode == null) {
			return startNode;
		}

		Node pointer1 = startNode;
		Node pointer2 = startNode;

		while (pointer2 != null && pointer2.getNext() != null && pointer2.getNext().getNext() != null) {
			pointer1 = pointer1.getNext();
			pointer2 = pointer2.getNext().getNext();

		}
		return pointer1;
	}

	private void printLinkList(Node startNode) {
		Node temp = startNode;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
	}

}
