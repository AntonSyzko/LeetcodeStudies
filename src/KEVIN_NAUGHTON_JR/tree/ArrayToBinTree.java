package KEVIN_NAUGHTON_JR.tree;

import java.util.Arrays;
import java.util.List;

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
every node never differ by more than 1.

Example

Given the sorted array [1, 2, 3, 4, 5, 6]

One possible answer is:
      4
    /   \
   2     5
  / \     \
 1   3     6
Sorted Array to Balanced Binary Search Tree solution in Java
In a Binary search tree, all the values less than or equal to a node’s value go in the left subtree of the node,
and all the values greater than the node’s value go in the right subtree of the node.

For the Binary Search Tree to be balanced, we need to make sure that we distribute values equally to
the left and right subtrees of every node.

To do this, we choose the value in the middle of the array and make that the root node.
 The values before the mid value go in the left subtree and the values after the mid value go in the right subtree.
 We do this recursively to construct the balanced binary search tree.
 */
public class ArrayToBinTree {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);//trabspose array to list
        TreeNode root = sortedArrayToBST(values);
        traverseInorder(root);
    }

    static TreeNode sortedArrayToBST(List<Integer> values) {//shell function
        if (values == null) {//pre check
            return null;
        }
        return insertBallanced(values, 0, values.size() - 1);//main worker function
    }


    private static TreeNode insertBallanced(List<Integer> values, int start, int end) {
        if (start > end) {//base case
            return null;
        }

        int mid = start + (end - start) / 2;//mid point with integer overflow

        TreeNode currentNode = new TreeNode(values.get(mid));//create new Node for mid point
        currentNode.left = insertBallanced(values, start, mid - 1);//recursively all below MID to left children
        currentNode.right = insertBallanced(values, mid + 1, end);//recursively all ABOVE MID to right children
        return currentNode;//return currnet to recusrive run
    }

    static void traverseInorder(TreeNode root) {
        if (root == null) {
            return;
        }

        traverseInorder(root.left);//first print lefts
        System.out.print(root.val + " ");//then  print root
        traverseInorder(root.right);//in the end rights
    }
}
