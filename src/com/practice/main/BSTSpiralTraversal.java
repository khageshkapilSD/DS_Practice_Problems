package com.practice.main;

import java.util.Stack;

//A Binary Tree node
public class BSTSpiralTraversal {
	class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static Node root;

	void printSpiral(Node node) {
		if (node == null)
			return; // NULL check

		// Create two stacks to store alternate levels
		Stack<Node> s1 = new Stack<Node>();// For levels to be printed from
											// right to left
		Stack<Node> s2 = new Stack<Node>();// For levels to be printed from left
											// to right

		// Push first level to first stack 's1'
		s1.push(node);

		// Keep ptinting while any of the stacks has some nodes
		while (!s1.empty() || !s2.empty()) {
			// Print nodes of current level from s1 and push nodes of
			// next level to s2
			while (!s1.empty()) {
				Node temp = s1.peek();
				s1.pop();
				System.out.print(temp.data + " ");

				// Note that is right is pushed before left
				if (temp.right != null)
					s2.push(temp.right);

				if (temp.left != null)
					s2.push(temp.left);

			}

			// Print nodes of current level from s2 and push nodes of
			// next level to s1
			while (!s2.empty()) {
				Node temp = s2.peek();
				s2.pop();
				System.out.print(temp.data + " ");

				// Note that is left is pushed before right
				if (temp.left != null)
					s1.push(temp.left);
				if (temp.right != null)
					s1.push(temp.right);
			}
		}
	}

	public static void main(String[] args) {
		BSTSpiralTraversal tree = new BSTSpiralTraversal();
		tree.root = tree.new Node(10);
		tree.root.left = tree.new Node(2);
		tree.root.right = tree.new Node(3);
		tree.root.left.left = tree.new Node(7);
		tree.root.left.right = tree.new Node(6);
		tree.root.right.left = tree.new Node(5);
		tree.root.right.right = tree.new Node(4);
		System.out.println("Spiral Order traversal of Binary Tree is ");
		tree.printSpiral(root);
	}
}
