package LEET_CODE.tree_traversals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

/*
given binary search tree and  int range
retrun sum of values of all nodes bethween given range
 */
public class RangeSumOfBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode f_left = new TreeNode(5);
        TreeNode f_rigth = new TreeNode(15);
        TreeNode ff_left = new TreeNode(3);
        TreeNode ff_right = new TreeNode(7);
        TreeNode ss_left = null;
        TreeNode ss_right = new TreeNode(18);
        root.left = f_left;
        root.right = f_rigth;
        f_left.left = ff_left;
        f_left.right = ff_right;
        f_rigth.left = ss_left;
        f_rigth.right = ss_right;
        int res_sum = rangeSumOfBSTRecursive(root, 7, 15);
        System.out.println(res_sum);


    }

    static int rangeSumOfBST(TreeNode root, int left_boundary, int right_boundary) {
        int sum_of_vals_between_range = 0;
        Stack<TreeNode> stack = new Stack<>();//stack holder
        stack.push(root);//first add

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.val >= left_boundary && current.val <= right_boundary) {//MIND && - so ONLY of both are true
                sum_of_vals_between_range += current.val;//actual addition
            }
            //BST is formed the way lefts are smaller , rights are bigger
            if (current.val > left_boundary && current.left != null) {//due to uper && left can match still but not right - so to stack
                stack.push(current.left);
            }
            if (current.val < right_boundary && current.right != null) {
                stack.push(current.right);
            }
        }
        return sum_of_vals_between_range;
    }


    static int rangeSumOfBST_BFS(TreeNode root, int left_boundary, int right_boundary) {
        int sum = 0;
        if(root == null) return sum;//edge case

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()){
            TreeNode current_in_que = que.remove();
            if(current_in_que.val >=left_boundary && current_in_que.val <= right_boundary){//actual case
                sum+=current_in_que.val;//add
            }

            //BST - bigger at left , so if left child exists and current node's val is bigger than our left range -
            // it's still matches and it's children can match - so add the left child to que for further processing
            if(current_in_que.left != null //if node has  left child at all
            && current_in_que.val > left_boundary){//AND value of node is bigger that left range - so it's still match in future checks
                que.add(current_in_que.left);//add to que
            }
            if(current_in_que.right != null //has right al all
                    && current_in_que.val < right_boundary){//AND value is lower than right range - still match im future checks
                que.add(current_in_que.right);//add to que
            }
        }
        return sum;
    }



        // recursion all below
    static int range_Sum;


    //breadth first search
    static int rangeSumOfBSTRecursive(TreeNode root, int left_boundary, int right_boundary) {
        range_Sum = 0;
        get_range_sum(root, left_boundary, right_boundary);
        return range_Sum;
    }

    private static void get_range_sum(TreeNode root, int left_boundary, int right_boundary) {
        if (root != null) {//base case kinda
            if (root.val >= left_boundary && root.val <= right_boundary) {
                range_Sum += root.val;//actual calc
            }
            if (root.val > left_boundary) {
                get_range_sum(root.left, left_boundary, right_boundary);//recursive ob left
            }
            if (root.val < right_boundary) {
                get_range_sum(root.right, left_boundary, right_boundary);//recursive on right
            }
        }
    }

}
