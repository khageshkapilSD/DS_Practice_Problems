package com.practice.main.customTreeOperations;

import java.util.Iterator;

import com.practice.main.dataStructuresImpl.BinarySearchTree;

public class InorderTraversal {

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
		bst.insert(30);
		bst.insert(10);
		bst.insert(50);
		bst.insert(20);
		bst.insert(15);
		bst.insert(40);
		bst.insert(5);
		bst.insert(70);
		
		/*
		 * Plainly print the nodes in order
		 */
		bst.printTreeInOrder();
		
		/*
		 * Get a list of node data type and iterate over it
		 */
		Iterator<Integer> inorderIterator = bst.getInorderList().iterator();
		while(inorderIterator.hasNext())
			System.out.print(inorderIterator.next()+" ");
	}
}
