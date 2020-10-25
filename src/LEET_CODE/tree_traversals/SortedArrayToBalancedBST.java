package LEET_CODE.tree_traversals;

import java.util.Arrays;
import java.util.List;

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example

Given the sorted array [1, 2, 3, 4, 5, 6]

One possible answer is:
      4
    /   \
   2     5
  / \     \
 1   3     6


 In a Binary search tree, all the values less than or equal to a node’s value go in the left subtree of the node,
 and all the values greater than the node’s value go in the right subtree of the node.

For the Binary Search Tree to be balanced, we need to make sure that
we distribute values equally to the left and right subtrees of every node.

To do this, we choose the value in the middle of the array and make that the root node.
values before the mid value go in the left subtree and the values after the mid value go in the right subtree.
 We do this recursively to construct the balanced binary search tree.

 */
public class SortedArrayToBalancedBST {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Array " + values);
        TreeNode root = sortedArrayToBST(values);
        inOrderTraversal(root);
    }

    //just to display correctly in order
    private static void inOrderTraversal(TreeNode root) {
        if (root == null) {//base case for recursion
            return;
        }

        inOrderTraversal(root.left);//lefts

        System.out.println(root.val);//print

        inOrderTraversal(root.right);//rigrts
    }



    private static TreeNode sortedArrayToBST(List<Integer> values) {
        if (values.isEmpty()) {//pre check
            return null;
        }

        return insertBalanced(values, 0, values.size() - 1);//recursively from start to end
    }


    private static TreeNode insertBalanced(List<Integer> values, int start, int end) {

        if (start > end) {//base case for recursion
            return null;
        }

        int mid = start + (end -start)/2;//mid , (int overflow counted in)


        TreeNode node = new TreeNode(values.get(mid));//new node creation , root when first, mid = root in BST

        //recursively left side, lower then MID - LEFT leafs
        node.left = insertBalanced(values, start, mid - 1);

        //recursively right side, bigger  then MID - RIGHT leafs
        node.right = insertBalanced(values, mid + 1, end);

        return node;//very node return

    }
}
