package KEVIN_NAUGHTON_JR.tree;

public class TreeDepthCount {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode f_left = new TreeNode(1);//leaf
        TreeNode f_rigth = new TreeNode(3);
        TreeNode f_right_left = new TreeNode(4);
        TreeNode f_rigth_right = new TreeNode(5);

        root.left = f_left;
        root.right = f_rigth;
        f_rigth.left = f_right_left;
        f_rigth.right = f_rigth_right;

        int depth = countTreeDepth(root);
        System.out.println(depth);
    }

    static int countTreeDepth(TreeNode root){
        if( root==null){
            return 0;
        }

        int maxLeftBranchDepth = countTreeDepth(root.left)+1;
        int maxRightBranchDepth = countTreeDepth(root.right)+1;

        return maxLeftBranchDepth > maxRightBranchDepth ? maxLeftBranchDepth : maxRightBranchDepth;
    }
}
