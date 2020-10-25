package LEET_CODE.tree_traversals;

import java.util.Stack;

public class FlattenTreeToLinkedList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode f_left = new TreeNode(3);
        TreeNode f_rigth = new TreeNode(2);
        TreeNode ff_left = new TreeNode(5);
        TreeNode ff_right = new TreeNode(3);
        TreeNode ss_left = null;//if last level left null - but smth on righ - false t
        TreeNode ss_right = new TreeNode(9);
        ;//last level right null
        root.left = f_left;
        root.right = f_rigth;
        f_left.left = ff_left;
        f_left.right = ff_right;
        f_rigth.left = ss_left;
        f_rigth.right = ss_right;

        System.out.println(root);
        flattenTree(root);
        System.out.println(root);
    }


    static void flattenTree(TreeNode root){
        if ( root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);//populate to start

        while (!stack.isEmpty()){

            TreeNode currentNode = stack.pop();

            if(currentNode.right != null){
                stack.push(currentNode.right);//first add right child
            }

            if(currentNode.left != null){
                stack.push(currentNode.left);//left second - so it's on top at the  moment
            }

            if(!stack.isEmpty()){//in case was one node only(root) - have to check
            //peeked is LEFT and we reassign to current right - this peeked left , thanks to peek - it stays in stack
                currentNode.right = stack.peek();//removes element from top - but does not remove it from very stack
            }
            currentNode.left = null;//lefts are now nulls - to flatten to all rights
        }
    }
}
