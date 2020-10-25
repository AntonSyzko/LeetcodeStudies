package LEET_CODE.tree_traversals;

import java.util.LinkedList;
import java.util.Queue;

/*
bin tree is complete if all levels have  nodes , and the non-null node is the most left of last level
 */
public class CompletenessOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode f_left = new TreeNode(2);
        TreeNode f_rigth = new TreeNode(3);
        TreeNode ff_left = new TreeNode(4);
        TreeNode ff_right = new TreeNode(5);
        TreeNode ss_left = new TreeNode(6);//if last level left null - but smth on righ - false t
        TreeNode ss_right = null;//last level right null
        root.left = f_left;
        root.right = f_rigth;
        f_left.left = ff_left;
        f_left.right = ff_right;
        f_rigth.left = ss_left;
        f_rigth.right = ss_right;

        boolean is_complete_tree = isBinTreeComplete(root);
        System.out.println(is_complete_tree);
    }

    static boolean isBinTreeComplete(TreeNode root){
        boolean null_node_met_so_far = false;//met the null node as  we  traverse
        Queue<TreeNode> queue = new LinkedList<>();//que to store  current  nodes
        queue.offer(root);//populate to start

        while (!queue.isEmpty()){//bounds for traversal
            TreeNode current_node = queue.poll();
            if(current_node == null){//null node met
                null_node_met_so_far = true;//set true
            }else {//not null node current
// but before null was already met - FALSE since only ONE null can it have (and it should be on last level right ), if smth appears after we met NULL - FALSE
                if(null_node_met_so_far) return false;
                queue.add(current_node.left);//order matters - left;s go first , if null at left - no Node should be at rright
                queue.add(current_node.right);
            }

        }

        return true;
    }
}
