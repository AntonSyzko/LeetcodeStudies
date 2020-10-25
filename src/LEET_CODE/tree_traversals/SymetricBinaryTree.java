package LEET_CODE.tree_traversals;

/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
 */
public class SymetricBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);


        boolean isSymmentric = isBinTreeSymmetric(node);
        System.out.println(isSymmentric);
    }

    //checks TWO nodes for symmetry
    private static boolean areBinTreeLeafsSymmetric(TreeNode node1, TreeNode node2){

        if(node1 == null && node2 == null) return true;//if BOTH null - TRUE

        if(node1 == null || node2 == null) return false;// if ONLY ONE null - FALSE

        return  node1.val == node2.val // if values are equal AND
                &&
                areBinTreeLeafsSymmetric(node1.left, node2.right)//mirror left and right are =
                &&
                areBinTreeLeafsSymmetric(node1.right, node2.left);//mirror right and left are =
    }

    //entry point for SINGLE node
    private static boolean isBinTreeSymmetric(TreeNode singleNode){
        if(singleNode==null) return true;//nothing to check OK

        return areBinTreeLeafsSymmetric(singleNode.left, singleNode.right);//check BOTH leafs of root
    }
}
