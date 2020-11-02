package HACKER_RANK.tree;

import java.util.Stack;

/*
pre order root left right
in order left root right
post order lef right root
 */
public class PreOrderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        TreeNode first_left = new TreeNode(1);
        TreeNode first_right = new TreeNode(3);
        TreeNode first_left_left = new TreeNode(4);
        TreeNode first_right_left = new TreeNode(7);
        TreeNode fisrt_left_right = new TreeNode(5);
        TreeNode first_right_right = new TreeNode(8);
        root.setLeft(first_left);
        root.setRight(first_right);
        first_left.setLeft(first_left_left);
        first_left.setRight(fisrt_left_right);
        first_right.setLeft(first_right_left);
        first_right.setRight(first_right_right);

        preOrderRecursive(root);

        System.out.println(" \r\n**************************************** ");
        preOrderIterative(root);

    }

    static void preOrderRecursive(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    static void preOrderIterative(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);

        while (!stack.isEmpty()){
            TreeNode current_node_from_top_of_Stack = stack.pop();
            System.out.print(current_node_from_top_of_Stack.val + " ");//pre order root get printed first
            if (current_node_from_top_of_Stack.right != null){//if right exists, otherwise  null to stack - wrong
                stack.add(current_node_from_top_of_Stack.right);//right goes first - but will be picked last , stack
            }
            if(current_node_from_top_of_Stack.left != null){
                stack.add(current_node_from_top_of_Stack.left);//left comes last - but will be popped out if stack first
            }
        }


    }
}
