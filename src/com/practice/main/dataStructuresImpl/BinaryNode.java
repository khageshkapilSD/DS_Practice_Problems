package com.practice.main.dataStructuresImpl;


public class BinaryNode<Type extends Comparable<Type>> {

	private Type data;
	private BinaryNode<Type> leftNode;
	private BinaryNode<Type> rightNode;
	
	public BinaryNode(Type data) {
		this.data = data;
		leftNode = rightNode = null;
	}
	
	
	public BinaryNode(Type data,BinaryNode<Type> leftNode,BinaryNode<Type> rightNode) {
		this.data = data;
		this.leftNode =  leftNode;
		this.rightNode = rightNode;
	}
	
	public BinaryNode<Type> getLeft() {
		return leftNode;
	}

	public void setLeft(BinaryNode<Type> leftNode) {
		this.leftNode = leftNode;
	}

	public BinaryNode<Type> getRight() {
		return rightNode;
	}

	public void setRight(BinaryNode<Type> rightNode) {
		this.rightNode = rightNode;
	}

	public void setData(Type data) {
		this.data = data;
	}

	public Type getData() {
		return data;
	}

}
