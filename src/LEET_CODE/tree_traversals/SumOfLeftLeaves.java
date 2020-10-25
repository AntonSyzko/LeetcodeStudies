package LEET_CODE.tree_traversals;

import java.util.Stack;

/*
leaf is the child that has NO any left or right children
 */

public class SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode f_left = new TreeNode(9);//leaf
        TreeNode f_rigth = new TreeNode(20);

        TreeNode ss_left = new TreeNode(15);//leaf
        TreeNode ss_right = new TreeNode(7);
        ;//last level right null
        root.left = f_left;
        root.right = f_rigth;
        f_rigth.left = ss_left;
        f_rigth.right = ss_right;

        //   int summa = sumOfLeftLeaves(root);
        int summ2 = sumOfLeftLeavesDFS(root);
        //  System.out.println(summa);
        System.out.println(summ2);

    }


    static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;//base case

        int sum_of_all_left_leaves_values = 0;//res

        if (root.left != null) {//if next left exists

            if (root.left.left == null && root.left.right == null) {//and it's leaves are BOTH null
                sum_of_all_left_leaves_values += root.left.val;//add the current ( whose leaves are all null ) to res
            } else {
                sum_of_all_left_leaves_values += sumOfLeftLeaves(root.left);//recursion of this left , since it's leaves are not null
            }
        }

        if (root.right != null) {//if current's right child leaf exists at all

            if (root.right.left != null || root.right.right != null) {// if one of it's leaves exists ( potential candidte to left leave )
                sum_of_all_left_leaves_values += sumOfLeftLeaves(root.right);//recurse on this right child leaf
            }
        }

        return sum_of_all_left_leaves_values;//aggregated res
    }


    static int sumOfLeftLeavesDFS(TreeNode root) {
        if (root == null) return 0;

        int sum_of_all_left_leaves_values = 0;

        Stack<TreeNode> stack = new Stack<>();//storage for  DFS

        stack.add(root);//add first

        while (!stack.isEmpty()) {

            TreeNode current_node_from_stack = stack.pop();//get from top of stack


            if (current_node_from_stack.left != null) {//has any left child

                if (current_node_from_stack.left.left == null && current_node_from_stack.left.right == null) {//BOTH of leaves are NULL
                    sum_of_all_left_leaves_values += current_node_from_stack.left.val;//add to res
                } else {//othervise
                    stack.add(current_node_from_stack.left);// add on top of stack to continue checking it's leaves
                }
            }

            if (current_node_from_stack.right != null) {//if has  any  right leaf
                if (current_node_from_stack.right.left != null || current_node_from_stack.right.right != null) {//if has any non null children
                    stack.add(current_node_from_stack.right);//add to stack to continue checking
                }
            }

        }
        return sum_of_all_left_leaves_values;//aggregated result

    }
}
