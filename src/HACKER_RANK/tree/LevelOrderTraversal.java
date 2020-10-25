package HACKER_RANK.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

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

        levelOrderTravers(root);

    }

        static void levelOrderTravers(TreeNode root){
        if(root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();//queue will add one by one

        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode current_node = queue.poll();
            System.out.print(current_node.val + " ");

            if(current_node.left != null){
                queue.add(current_node.left);//lefts first level by level
            }

            if(current_node.right != null){
                queue.add(current_node.right);
            }
        }
        }
}
