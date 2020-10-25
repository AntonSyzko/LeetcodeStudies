package KEVIN_NAUGHTON_JR.tree;

/*
leaf is the child that has NO any left or right children
 */
public class SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode f_left = new TreeNode(9);//leaf
        TreeNode f_rigth = new TreeNode(20);

        TreeNode ss_left = new TreeNode(15);//leaf
        TreeNode ss_right = new TreeNode(7);

        root.left = f_left;
        root.right = f_rigth;
        f_rigth.left = ss_left;
        f_rigth.right = ss_right;

        int sum = sumOfLeftLeaves(root);
        System.out.println(sum);


    }

// time O(n)
    static int  sumOfLeftLeaves(TreeNode root){


        if( root == null){//base case
            return 0;
        } else if (
                root.left != null             // if left exists
                && root.left.left == null     // and left's left is null
                && root.left.right == null){  // and left's right is null

            return root.left.val + //add this current left's val
                    sumOfLeftLeaves(root.right); // add - next recursion calls on right

        } else { // if not ( left was null or any of it's children were non null )

            return  sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right); // calculate for both left and right children and add to res
        }

    }
}
