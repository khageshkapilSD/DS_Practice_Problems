package com.practice.main;

public class Tree {
	class Node{
		Node left, right;
		int key;
		
		public Node(int data) {
			key = data;
			left = null;
			right = null;
		}
	}
	
	Node root;
	
	public Tree() {
		root = null;
	}
	
	private void insert(int data) {
		root = insertIntoTree(root, data);
	}
	
	private Node insertIntoTree(Node root, int data) {
		if(root==null){
			root = new Node(data);
			return root;
		}
		if (root.key>data) {
			root.left = insertIntoTree(root.left, data);
		}
		else{
			root.right = insertIntoTree(root.right, data);
		}
		return root;
	}
	
	private void inOrderTraverse(Node root) {
		if(root!=null){
			inOrderTraverse(root.left);
	        System.out.println(root.key);
	        inOrderTraverse(root.right);
		}
	}
	
	private void preOrderTraverse(Node root) {
		if(root!=null){
			System.out.println(root.key);
			preOrderTraverse(root.left);
			preOrderTraverse(root.right);
		}
	}
	
	int count = 0;
	Node res = null;
	private Node findKthLargestItem(Node node, int k) {
		if (node == null || count > k) {
			return null;
		}
		findKthLargestItem(node.right, k);
		count++;
		if (count == k) {
			res = node;
			return node;
		}
		findKthLargestItem(node.left, k);
		return res;
	}
	
	private void postOrderTraverse(Node root) {
		if(root!=null){
			postOrderTraverse(root.left);
			postOrderTraverse(root.right);
	        System.out.println(root.key);
		}
	}
	
	Node deleteRec(Node root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)  return root;
 
        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
 
        // if key is same as root's key, then This is the node
        // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            else{
            	root.key = minValue(root.right);
            	// Delete the inorder successor
                root.right = deleteRec(root.right, root.key);
            }   
        }
        return root;
    }
	
	int minValue(Node root)
    {
        int minv = root.key;
        while (root.left != null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
	
	private void printBoundary(Node root) {
		if(root!=null){
			System.out.print(root.key);
//			printLeft(root);
			printLeftRec(root);
			printLeaf(root);
			printRight(root);
		}
	}
	
	Node printLeaf(Node root){
		if(root!=null){
			printLeaf(root.left);
			if(root.left==null&&root.right==null)
				System.out.print("-"+root.key);
			printLeaf(root.right);
		}
		return root;
	}
	
	void printLeft(Node root){
		if(root==null)
			return;
		while (root.left.left!=null) {
			System.out.print("-"+root.left.key);
			root=root.left;
		}
	}
	
	Node printLeftRec(Node root){
		if(root==null)
			return null;
		if(root.left.left!=null){
			System.out.print("-"+root.left.key);
			printRight(root.left);
		}
		return root;
	}
	
	Node printRight(Node root){
		if(root==null)
			return null;
		if(root.right.right!=null){
			printRight(root.right);
			System.out.print("-"+root.right.key);
		}
		return root;
	}
	
	public static void main(String[] args) {
		Tree binaryTree = new Tree();
		binaryTree.insert(50);
		binaryTree.insert(30);
		binaryTree.insert(80);
		binaryTree.insert(10);
		binaryTree.insert(40);
		binaryTree.insert(60);
		binaryTree.insert(100);
		binaryTree.insert(1);
		binaryTree.insert(2);
		binaryTree.insert(3);
		binaryTree.insert(4);
		binaryTree.insert(5);
		binaryTree.insert(6);
		binaryTree.insert(7);
		binaryTree.insert(41);
		binaryTree.insert(53);
		binaryTree.insert(61);
		binaryTree.insert(49);
//		binaryTree.inOrderTraverse(binaryTree.root);
//		System.out.println("********************");
//		binaryTree.preOrderTraverse(binaryTree.root);
//		System.out.println("********************");
//		binaryTree.postOrderTraverse(binaryTree.root);
//		Node n = binaryTree.findKthLargestItem(binaryTree.root,7);
//		System.out.println(n.key);
//		binaryTree.deleteRec(binaryTree.root, 80);
		binaryTree.printBoundary(binaryTree.root);
	}
}
