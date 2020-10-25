package KEVIN_NAUGHTON_JR.tree;

public class ValidBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode f_left = new TreeNode(1);//leaf
        TreeNode f_rigth = new TreeNode(3);



        root.left = f_left;
        root.right = f_rigth;


        boolean isValid = isTreeValidBST(root);
        System.out.println(isValid);
    }

    static boolean isTreeValidBST(TreeNode root){

        return validateTree(root, null, null);
    }


    //real method
    private static boolean validateTree(TreeNode root, Integer maxValue, Integer minValue) {
        if( root == null ){//reached last leaf - end , got here - true
            return true;
        } else if ( maxValue != null && root.val >= maxValue //if max exists AND node's value is =MORE than MAX - WRONG
                || //OR
                minValue !=null && root.val <= minValue)//if min exists AND node value =LESS than MIN - WRONG
        {
            return false;//WRONG

        }else {

            return validateTree(root.left, root.val, minValue)//validate left subtree, MAX - is Roots of this subtree value, all the  children of left have to be smaller
                    && validateTree(root.right, maxValue, root.val);//validate right subtree, MIN is root of this subtrree val - since all the  children of right has to be bigger
        }
    }
}
