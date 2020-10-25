package LEET_CODE.tree_traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
get the right_mOST nodes of a bin tree
so rights of each level
one can use DFS or BFS and store levels and nodes
or
 */
public class BinTreeRightSideView {
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

        List<Integer> res = rightSideViewBFS(root);
        res.stream().forEach(System.out::println);
    }

    // O(n)   O (n) 
    static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();//BFS

        if (root == null) return res;

        que.offer(root);

        while (!que.isEmpty()) {

            int que_size = que.size();
//checking inside current que  elemnts, and the 0 elemnt is rightmost node - since we are adding it first to que
            for (int que_element = 0; que_element < que_size; que_element++) {

                TreeNode current_node = que.poll();//poll not pop - keep it in que don't remove

                if (que_element == 0) {//rightmost node of a LEVEL goes  here , other inside level right won't get to 0 index
                    res.add(current_node.val);
                }
                if (current_node.right != null) {
                    que.add(current_node.right);//right goes first
                }
                if (current_node.left != null) {
                    que.add(current_node.left);
                }
            }
        }
        return res;
    }


    //same but lefts go first and checking the  vals of last in que ( which will be the  right most ones )
    static List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();//queue -> BFS

        if (root == null) return res;

        que.offer(root);

        while (!que.isEmpty()) {

            int que_size = que.size();
//checking inside current que a;; elemnts, and the last  element is rightmost node - since we are adding it last  to que
            for (int que_level_element = 0; que_level_element < que_size; que_level_element++) {

                TreeNode current_node = que.remove();// get the node and extract it from que
//size -1 = last in current level que - so it's the right most
                if (que_level_element == que_size-1) {//rightmost node of a LEVEL goes  here , other inside level right won't get lst  index
                    res.add(current_node.val);
                }
                if (current_node.left != null) {
                    que.add(current_node.left);//left  goes first
                }
                if (current_node.right != null) {//right last and it is at {size -1 } index
                    que.add(current_node.right);
                }
            }
        }
        return res;
    }
}
