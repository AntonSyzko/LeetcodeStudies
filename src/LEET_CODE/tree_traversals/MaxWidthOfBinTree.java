package LEET_CODE.tree_traversals;

import java.util.HashMap;
import java.util.Map;

/*
width between leftmost and rightmost - null counts
here not values but positions in tree
left node position is it's prev * 2 , right = prev *2 +1
so end value will be leftmost - rightmost +1
 */
public class MaxWidthOfBinTree {

    public static void main(String[] args) {


        TreeNode root = new TreeNode(1);
        TreeNode f_left = new TreeNode(3);
        TreeNode f_rigth = new TreeNode(2);
        TreeNode ff_left = new TreeNode(5);
        TreeNode ff_right = new TreeNode(3);
        TreeNode ss_left = null;//if last level left null - but smth on righ - false t
        TreeNode ss_right = new TreeNode(9);;//last level right null
        root.left = f_left;
        root.right = f_rigth;
        f_left.left = ff_left;
        f_left.right = ff_right;
        f_rigth.left = ss_left;
        f_rigth.right = ss_right;

        int width_of_tree = widthOfBinTree(root);

        System.out.println("width " + width_of_tree);
    }

    static int max_width;
    static Map<Integer, Integer> leftmost_positions;

    static int widthOfBinTree(TreeNode root){
    max_width = 0;
    leftmost_positions = new HashMap<>();
    getWidth(root, 0,0);
    return max_width;
    }

    private static void getWidth(TreeNode node, int level_depth, int node_position) {

        if(node==null) return;

        leftmost_positions.computeIfAbsent(level_depth, x -> node_position);//lefts only

        max_width = Math.max(max_width, node_position-leftmost_positions.get(level_depth)+1);//left +1

        getWidth(node.left, level_depth+1, node_position*2);//lefts, next level depth, position *2 for lefts

        getWidth(node.right, level_depth+1, node_position*2+1);//rights, next depth level, postion *2 +1 for rights
    }
}
