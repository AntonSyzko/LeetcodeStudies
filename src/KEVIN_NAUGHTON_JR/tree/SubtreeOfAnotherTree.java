package KEVIN_NAUGHTON_JR.tree;


public class SubtreeOfAnotherTree {

    public static void main(String[] args) {

    }


    static boolean isSubtree(TreeNode origin, TreeNode toCompare) {
        if (origin == null) {//nothing to compare with
            return false;
        } else if (isSameTree(origin, toCompare)) {//if same fromm root level
            return true;
        } else {
            return isSameTree(origin.left, toCompare) && isSameTree(origin.right, toCompare);//subtrees comparising
        }
    }

    static boolean isSameTree(TreeNode treeA, TreeNode treeB) {
        if (treeA == null || treeB == null) {//if one is null
            return treeA == null && treeB == null;//then true only if both null
        } else if (treeA.val == treeB.val) {//compare values
            //recursion if val same - then left and right children check
            return isSameTree(treeA.left, treeB.left) && isSameTree(treeA.right, treeB.right);
        } else {
            return false;//not same values
        }

    }
}
