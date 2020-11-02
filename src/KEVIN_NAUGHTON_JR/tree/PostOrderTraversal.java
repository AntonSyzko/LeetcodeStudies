package KEVIN_NAUGHTON_JR.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
lefts, rights, root
 */
public class PostOrderTraversal {

    public static void main(String[] args) {
       TreeNode root = new TreeNode(1);
        TreeNode root_right = new TreeNode(2);
        TreeNode root_right_left = new TreeNode(3);
        root.left = null;
        root.right = root_right;
        root_right.left = root_right_left;

        List<Integer> postOrdered = postOrderTraverse(root);
        System.out.println(postOrdered);


    }


    static List<Integer> postOrderTraverse(TreeNode root){
        List<Integer> valuesInPostOrder = new ArrayList<>();//res

        if( root == null){//pre check
            return valuesInPostOrder;
        }


        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);//root at the  start

        while (!stack.isEmpty()){//while in stack

            TreeNode current = stack.pop();
            valuesInPostOrder.add(0, current.val);// !!! at POS ZERO (0 ) - so shifting right at every next insertion

            if(current.left != null){//first left children if exist
                stack.push(current.left);
            }

            if(current.right != null){//second right children if exist
                stack.push(current.right);
            }
        }

        return valuesInPostOrder;
    }
}
