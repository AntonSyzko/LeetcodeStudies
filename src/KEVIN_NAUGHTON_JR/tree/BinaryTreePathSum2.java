package KEVIN_NAUGHTON_JR.tree;

import java.util.ArrayList;
import java.util.List;

/*
given bin tree find all root-to-leaf paths adding to given sum,
 count int ONLY root-to-leaf paths -leaf is  node without children (last left or right )

 */
public class BinaryTreePathSum2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode f_left = new TreeNode(2);//leaf
        TreeNode f_rigth = new TreeNode(3);

        TreeNode ss_left = new TreeNode(5);//leaf
        TreeNode ss_right = new TreeNode(5);//leaf


        root.left = f_left;
        root.right = f_rigth;
        f_left.right = ss_left;
        f_rigth.right = ss_right;

        List<List<Integer >> paths = pathSum(root,3);
        paths.stream().forEach(System.out::println);
    }


    static List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> paths = new ArrayList<>();//res

        findPaths(root, sum, new ArrayList<Integer>(), paths);//shell func

        return paths;
    }

    private static void findPaths(TreeNode root, int sum, List<Integer> current_path, List<List<Integer>> paths) {
        if( root == null){//base case
            return;
        }

        if(root.val == sum && // if current node's value = sum we are currntly ( after substractions)  looking for AND
                root.left == null && root.right == null){//its a leaf node - means END of search

            paths.add(current_path);//add current path  to RES

            return;//exit func, NO recursive calls anymore
        }

        //recusrive on LEFT child, SUBSTRACT from sum the value of CURRENT NODE
        findPaths(root.left, sum - root.val, new ArrayList<Integer>(), paths);
        
        //recusrive on RIGHT child, SUBSTRACT from sum the value of CURRENT NODE
        findPaths(root.right, sum - root.val, new ArrayList<Integer>(), paths);

    }
}
