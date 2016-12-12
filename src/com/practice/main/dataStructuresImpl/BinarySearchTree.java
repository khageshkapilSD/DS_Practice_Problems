package com.practice.main.dataStructuresImpl;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
	
	private BinaryNode<T> root = null;
	
	public BinarySearchTree() {
	}
	
	public BinarySearchTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	}
	
	public void insert(T nodeData) {
		BinaryNode<T> newNode = new BinaryNode<T>(nodeData);
		root = insert(root, newNode);
	}
	
	private BinaryNode<T> insert(BinaryNode<T> parent, BinaryNode<T> nodeToBeInserted) {
		if(parent==null)
			parent = nodeToBeInserted;
		else {
			if(nodeToBeInserted.getData().compareTo(parent.getData())>0)
				parent.setRight(insert(parent.getRight(),nodeToBeInserted));
			else if(nodeToBeInserted.getData().compareTo(parent.getData())<0)
				parent.setLeft(insert(parent.getLeft(),nodeToBeInserted));
		}
		return parent;
	}
	
	public BinaryNode<T> delete(T dataOfNodeToBeDeleted) {
		return new BinaryNode<T>(dataOfNodeToBeDeleted);
	}
	
	public void printTreeInOrder() {
		getTreeInOrder(root,true,null);
	}
	
	public List<T> getInorderList() {
		return getTreeInOrder(root,false,null);
	}
	
	private List<T> getTreeInOrder(BinaryNode<T> node, boolean shouldPrint, List<T> traversalList){
		if(traversalList==null)
			traversalList = new ArrayList<T>();
		if(node!=null) {
			getTreeInOrder(node.getLeft(),shouldPrint,traversalList);
			if(shouldPrint)
				System.out.println(node.getData());
			traversalList.add(node.getData());
			getTreeInOrder(node.getRight(),shouldPrint,traversalList);
		}
		return traversalList;
	}
	
	public void printTreeReverseInOrder() {
		getTreeReverseInOrder(root,true,null);
	}
	
	public List<T> getReverseInOrderList() {
		return getTreeReverseInOrder(root,false,null);
	}
	
	private List<T> getTreeReverseInOrder(BinaryNode<T> node, boolean shouldPrint,
			List<T> traversalList) {
		if(traversalList==null)
			traversalList =  new ArrayList<T>();
		if(node!=null) {
			if(node.getRight()!=null)
				getTreeReverseInOrder(node.getRight(),shouldPrint,traversalList);
			if(shouldPrint)
				System.out.println(node.getData());
			traversalList.add(node.getData());
			getTreeReverseInOrder(node.getLeft(),shouldPrint,traversalList);
		}
		return traversalList;
	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.insert(30);
		bst.insert(10);
		bst.insert(20);
		bst.insert(15);
		bst.printTreeInOrder();
	}
}