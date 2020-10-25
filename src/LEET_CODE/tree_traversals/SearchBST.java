package LEET_CODE.tree_traversals;

public class SearchBST {

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

        TreeNode foundNode = searchNodeInBinSearchTree(root, 3);
        System.out.println(" found " + foundNode);
    }

    static TreeNode searchNodeInBinSearchTree(TreeNode root, int value){
        if( root == null) return null;//base case for recursion

        if(root.val == value) return root;//actual match check

        if( root.val < value){//since BST is lower at lefts
            return searchNodeInBinSearchTree(root.left, value);//recurse on left subtree
        } else {//higher at right
            return searchNodeInBinSearchTree(root.right, value);//recusrsion on right side
        }
    }
}
