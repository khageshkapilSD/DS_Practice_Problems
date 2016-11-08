package com.practice.main;

//class NodeTree {
//    
//    int data;
//    NodeTree left, right;
//     
//    NodeTree(int d) {
//        data = d;
//        left = right = null;
//    }
//}
 
public class SortedArrayToBST {
     
    static NodeTree root;
 
    /* A function that constructs Balanced Binary Search Tree 
     from a sorted array */
    NodeTree sortedArrayToBST(int arr[], int start, int end) {
 
        /* Base Case */
        if (start > end) {
            return null;
        }
 
        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        NodeTree NodeTree = new NodeTree(arr[mid]);
 
        /* Recursively construct the left subtree and make it
         left child of root */
        NodeTree.left = sortedArrayToBST(arr, start, mid - 1);
 
        /* Recursively construct the right subtree and make it
         right child of root */
        NodeTree.right = sortedArrayToBST(arr, mid + 1, end);
         
        return NodeTree;
    }
 
    /* A utility function to print preorder traversal of BST */
    void preOrder(NodeTree NodeTree) {
        if (NodeTree == null) {
            return;
        }
        System.out.print(NodeTree.data + " ");
        preOrder(NodeTree.left);
        preOrder(NodeTree.right);
    }
     
    public static void main(String[] args) {
        SortedArrayToBST tree = new SortedArrayToBST();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        root = tree.sortedArrayToBST(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST");
        tree.preOrder(root);
    }
}