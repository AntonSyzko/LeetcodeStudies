package LEET_CODE.tree_traversals;

/*
tree is unival if all the node  values are same, null does not count
    1
   1 1
  1 1     -is unival
 */
public class UnivaluedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode f_left = new TreeNode(1);
        TreeNode f_rigth = new TreeNode(1);
        TreeNode ff_left = new TreeNode(1);
        TreeNode ff_right = new TreeNode(1);
        TreeNode ss_left = null;
        TreeNode ss_right = new TreeNode(1);
        root.left = f_left;
        root.right = f_rigth;
        f_left.left = ff_left;
        f_left.right = ff_right;
        f_rigth.left = ss_left;
        f_rigth.right = ss_right;
        boolean isUnival = isTreeUnival(root);
        System.out.println(isUnival);
    }

    static boolean isTreeUnival(TreeNode root){
        boolean left_subtree_unival =
                root.left==null //if subtree to left is null - OK, this is base case, cause recursion will stop here
                || root.val == root.left.val // OR this value = next left val
                && isTreeUnival(root.left); // and recursively all the lefts , since root.LEFT is placed to recursive function

        boolean right_subtree_unival =
                root.right==null//end
                        || root.val == root.right.val//right vals are equal
                        && isTreeUnival(root.right);//recursive all next to eacg other rights

        return left_subtree_unival && right_subtree_unival;//if both all lefts and all rights are true
    }
}
