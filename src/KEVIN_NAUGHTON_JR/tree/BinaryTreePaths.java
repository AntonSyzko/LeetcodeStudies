package KEVIN_NAUGHTON_JR.tree;

import java.util.ArrayList;
import java.util.List;

/*
given bin tree find all paths to leaf node, leaf node - node without children (last left or right )
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode f_left = new TreeNode(2);//leaf
        TreeNode f_rigth = new TreeNode(3);

        TreeNode ss_left = new TreeNode(5);//leaf

        root.left = f_left;
        root.right = f_rigth;
        f_left.right = ss_left;

        List<String > paths = binTreePaths(root);
        paths.stream().forEach(System.out::println);
    }

    static List<String> binTreePaths(TreeNode root){

        List<String > paths = new ArrayList<>();

        if( root == null) return paths;//pre check

        dfs(root,"",paths);//recursive on all children

        return paths;
    }

    private static void dfs(TreeNode root, String path, List<String> paths) {

        path += root.val;//empty string + val of root in beginning

        if( root.left == null && root.right == null){//base case , if no children
            paths.add(path);//to res
            return;//end of function
        }

        if(root.left != null){//if left child exists
            dfs(root.left, path+"->", paths);//DFS on left child, path + ->
        }

        if(root.right != null){//if right child exists
            dfs(root.right, path+"->", paths);//DFS on right child, path + ->
        }
    }
}
