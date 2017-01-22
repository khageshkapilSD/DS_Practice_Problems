package com.practice.main.customTreeOperations;

import java.util.Iterator;
import com.practice.main.dataStructuresImpl.BinarySearchTree;
import com.practice.main.dataStructuresImpl.TreePrinter;

public class MirrorImage {

	public static void main(String[] args) {
		
		//Create a BST and add nodes to it
		/*
		 *      30
		 *     /  \
		 *   10    50
		 *  / \    / \
		 * 5  20  40  70
		 *    /
		 *  15 
		 *  
		 * */
		
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
		
		System.out.println(" ");
		
		BinarySearchTree<Integer> bstMirr = bst.getMirrorImageTree();
		treePrinter = new TreePrinter(bstMirr);
		treePrinter.print("Mirror tree");
		bstMirr.printTreeInOrder();
	}
}
