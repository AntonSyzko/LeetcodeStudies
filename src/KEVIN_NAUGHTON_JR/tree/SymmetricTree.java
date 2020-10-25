package KEVIN_NAUGHTON_JR.tree;

public class SymmetricTree {

    public static void main(String[] args) {

    }


    static boolean isSymmetric(TreeNode root){
        if( root == null){
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    //shell O(n)
    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left==null || right == null){//base case
            return left == right;
        }
        if( left.val != right.val){//actual check
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
