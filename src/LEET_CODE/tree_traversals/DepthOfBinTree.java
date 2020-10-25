package LEET_CODE.tree_traversals;

public class DepthOfBinTree {

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

        int depth_of_tree = findDepthOfBinTree(root);
        System.out.println(" depth " + depth_of_tree);
    }

    static int findDepthOfBinTree(TreeNode root) {
        if (root == null) return 0;//base case

        int depth_of_left_subtree = findDepthOfBinTree(root.left);
        int depth_of_right_subtree = findDepthOfBinTree(root.right);

        return Math.max(depth_of_left_subtree, depth_of_right_subtree) + 1;// +1 to include current level when we reached end
    }
}
