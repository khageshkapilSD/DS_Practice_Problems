package com.practice.main.importantInterviewQuestion;

import java.util.List;

import com.practice.main.dataStructuresImpl.BinaryNode;
import com.practice.main.dataStructuresImpl.BinarySearchTree;
import com.practice.main.dataStructuresImpl.TreePrinter;

public class GreaterElementsSumTree {
	
	/*
	 * 
	 *          50                                 260
	 *        /    \                              /   \
	 *      30      70        ====>            330     150
	 *     / \     /  \                       /  \     /  \
	 *   20  40   60   80                   350  300  210  80
	 */
	BinaryNode<Integer> getSumTree(BinaryNode<Integer> root) {
		List<Integer> nodeList = (new BinarySearchTree<>(root)).getReverseInOrderList();
		for(int i=0;i<nodeList.size()-1;i++) {
			nodeList.set(i+1 , nodeList.get(i) + nodeList.get(i+1));
		}
		return createTreeFromList(nodeList,new BinaryNode<Integer>(0),0,nodeList.size()-1);
	}
	
	BinaryNode<Integer> createTreeFromList(List<Integer> inputList, BinaryNode<Integer> root,
			int begin, int end) {
		if(!(begin>end)) {
			int mid = (begin+end)/2;
			root.setData(inputList.get(mid));
			BinaryNode<Integer> rightNode = createTreeFromList(inputList,new BinaryNode<Integer>(0),begin,mid-1);
			root.setRight(rightNode.getData()==0?null:rightNode);
			BinaryNode<Integer> leftNode = createTreeFromList(inputList,new BinaryNode<Integer>(0),mid+1,end);
			root.setLeft(leftNode.getData()==0?null:leftNode);
			return root;
		}
		else
			return root;
		
	}
	
	public static void main(String[] args) {
		GreaterElementsSumTree gest = new GreaterElementsSumTree();
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		TreePrinter treePrinter = null;
		bst.insert(50);
		bst.insert(30);
		bst.insert(70);
		bst.insert(20);
		bst.insert(40);
		bst.insert(60);
		bst.insert(80);
		
		treePrinter = new TreePrinter(bst);
		treePrinter.print("Tree");
		
		bst = new BinarySearchTree<>(gest.getSumTree(bst.getRoot()));
		treePrinter = new TreePrinter(bst);
		treePrinter.print("Sum Tree");
	}

}
