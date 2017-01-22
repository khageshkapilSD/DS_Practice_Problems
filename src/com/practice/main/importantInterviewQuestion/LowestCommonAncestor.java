package com.practice.main.importantInterviewQuestion;

import com.practice.main.dataStructuresImpl.BinaryNode;
import com.practice.main.dataStructuresImpl.BinarySearchTree;
import com.practice.main.dataStructuresImpl.TreePrinter;

public class LowestCommonAncestor {

	BinaryNode<Integer> getLCA(BinaryNode<Integer> root, BinaryNode<Integer> A,
			BinaryNode<Integer> B) {
		if(root==null)
			return null;
		if(root.getData().equals(A.getData()) || root.getData().equals(B.getData()))
			return root;
		
		BinaryNode<Integer> leftResult = getLCA(root.getLeft(),A,B);
		BinaryNode<Integer> rightResult = getLCA(root.getRight(),A,B);
		
		if(leftResult!=null && rightResult!=null)
			return root;
		
		return leftResult==null?rightResult:leftResult;
		
	}
	
	public static void main(String[] args) {
		LowestCommonAncestor lca = new LowestCommonAncestor();
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		TreePrinter treePrinter = null;
		bst.insert(50);
		bst.insert(30);
		bst.insert(70);
		bst.insert(20);
		bst.insert(40);
		bst.insert(60);
		bst.insert(65);
		bst.insert(25);
		bst.insert(35);
		bst.insert(38);
		bst.insert(32);
		bst.insert(21);
		bst.insert(28);
		bst.insert(18);
		bst.insert(100);
		bst.insert(80);
		bst.insert(5);
		bst.insert(15);
		bst.insert(45);
		
		treePrinter = new TreePrinter(bst);
		treePrinter.print("Tree");
		
		System.out.println( lca.getLCA (
				bst.getRoot(),new BinaryNode<Integer>(32), new BinaryNode<Integer>(40)).getData());
	}
}
