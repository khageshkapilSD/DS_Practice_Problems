package com.practice.main.dataStructuresImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
	
	protected BinaryNode<T> root = null;
	
	public BinarySearchTree() {
	}
	
	public BinarySearchTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	}
	
	public BinarySearchTree(BinaryNode<T> rootNode) {
		this.root = deepCopy(this.root,rootNode);
	}
	
	private BinaryNode<T> deepCopy(BinaryNode<T> copy, BinaryNode<T> root) {
		if(root==null)
			return null;
		
		copy = new BinaryNode<T>(root.getData());
		
		copy.setLeft(deepCopy(copy.getLeft(), root.getLeft()));
		copy.setRight(deepCopy(copy.getRight(), root.getRight()));
		
		return copy;
	}
	
	public void insert(T nodeData) {
		root = insert(root, nodeData);
	}
	
	protected BinaryNode<T> insert(BinaryNode<T> parent, T nodeToBeInserted) {
		if(parent==null)
			parent = new BinaryNode<T>(nodeToBeInserted);
		else {
			if(nodeToBeInserted.compareTo(parent.getData())>0)
				parent.setRight(insert(parent.getRight(),nodeToBeInserted));
			else if(nodeToBeInserted.compareTo(parent.getData())<0)
				parent.setLeft(insert(parent.getLeft(),nodeToBeInserted));
		}
		return parent;
	}
	
	public void remove(T data) {
        root = remove(data, root);
    }

    protected BinaryNode<T> remove(T data, BinaryNode<T> root) {
        if(root == null) {
            return null;
        }

        int compareResult = root.getData().compareTo(data);

        if(compareResult > 0) {
            root.setLeft(remove(data, root.getLeft()));
        } else if(compareResult < 0) {
            root.setRight(remove(data, root.getRight()));
        } else if(root.getLeft() != null && root.getRight() != null) {
            root.setData(findMin(root.getRight()).getData());
            root.setRight(remove(root.getData(), root.getRight()));
        } else {
            root = root.getLeft() != null ? root.getLeft() : root.getRight();
        }

        return root;
    }
    
    protected BinaryNode<T> findMin(BinaryNode<T> root) {
        if(root == null) {
            return null;
        } else if(root.getLeft() == null) {
            return root;
        } else {
            return findMin(root.getLeft());
        }
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
	
	public int height() {
		return height(root);
	}
	
	protected int height(BinaryNode<T> root) {
        if(root == null) {
            return -1;
        } else {
            return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
        }
    }
	
	 public BinaryNode<T> getRoot() {
		return root;
	}
	
	public BinarySearchTree<T> getMirrorImageTree(){
		BinarySearchTree<T> mirrorImageTree = new BinarySearchTree<T>(root);
		return new BinarySearchTree<T>(
				getMirrorImageTree(mirrorImageTree.root));
	}
	
	private BinaryNode<T> getMirrorImageTree(BinaryNode<T> node) {
		if(node==null)
			return null;
		if(node.getLeft()==null && node.getRight()==null)
			return node;
		
		BinaryNode<T> tempNode = node.getLeft();
		
		node.setLeft(node.getRight());
		node.setLeft(getMirrorImageTree(node.getLeft()));
		
		node.setRight(tempNode);
		node.setRight(getMirrorImageTree(node.getRight()));
		
		return node;
		
	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		TreePrinter treePrinter = null;
		bst.insert(30);
		bst.insert(10);
		bst.insert(50);
		bst.insert(20);
		bst.insert(15);
		bst.insert(40);
		bst.insert(5);
		bst.insert(70);
		
		treePrinter = new TreePrinter(bst);
		treePrinter.print("tree");
		bst.printTreeInOrder();
		bst.printTreeReverseInOrder();
		
		BinarySearchTree<Integer> bstMirr = bst.getMirrorImageTree();
		treePrinter = new TreePrinter(bstMirr);
		treePrinter.print("Mirror tree");
		bstMirr.printTreeInOrder();
		bstMirr.printTreeReverseInOrder();
		
		
	}
}