package LEET_CODE.tree_traversals;

public class InvertBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode firstLeft = new TreeNode(2);
        TreeNode firstRight = new TreeNode(3);

        TreeNode secondFirstLeft = new TreeNode(4);
        TreeNode secondFirstRight = new TreeNode(5);

        TreeNode secondRightLeft = new TreeNode(6);
        TreeNode secondRightRight = new TreeNode(7);

        root.setLeft(firstLeft);
        root.setRight(firstRight);
        firstLeft.setLeft(secondFirstLeft);
        firstLeft.setRight(secondFirstRight);
        firstRight.setLeft(secondRightRight);
        firstRight.setRight(secondRightRight);

        System.out.println(" before inversion " + root);
        TreeNode inverted = invertBinaryTree(root);
        System.out.println("after inversion " + inverted);
    }



    static TreeNode invertBinaryTree(TreeNode root) {

        if (root == null) {//base case to exit recursion
            return root;
        }

        TreeNode leftSibling = invertBinaryTree(root.left);//recursively get left subtree
        TreeNode rightSibling = invertBinaryTree(root.right);//recursively get right subtree

        //swap em
        root.left = rightSibling;
        root.right = leftSibling;

        return root;
    }


}