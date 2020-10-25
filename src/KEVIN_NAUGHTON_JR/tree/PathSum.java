package KEVIN_NAUGHTON_JR.tree;

/*
given bin tree find if nodes from root to leaf equal to given sum
   5
 2   3
1 3 2 6

val b = true - 5 + 2 + 1 at left subtree

 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rl = new TreeNode(1);
        TreeNode rr = new TreeNode(4);
        root.right = rr;
        root.left = rl;

        boolean hasPath = hasPath(root, 4);
        System.out.println(hasPath);

    }

    static boolean hasPath(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        } else {
            return hasPath(root.left, sum - root.val) || hasPath(root.right, root.val);
        }
    }
}