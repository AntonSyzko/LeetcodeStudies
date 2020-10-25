package LEET_CODE.tree_traversals;

/*
prune entire subtree if one of it's nodes contain '1'
 */
public class PruneBinaryTree {

    static TreeNode pruneTree(TreeNode root){
        if(root == null) return null;

        containsValue(root);//recursive func

        return root;//we are modyfying in place - so same tree returned ( just modified)
    }

    private static boolean containsValue(TreeNode node) {
        if( node == null){//base case
            return false;
        }

        boolean left_subtree_contains_one = containsValue(node.left);
        boolean right_subtree_contains_one = containsValue(node.right);

        if(!left_subtree_contains_one){//if '1' value occured at left - boolean is TRUE and we can set the entire subtree to null - PRUNE IT
            node.left = null;
        }
        if(!right_subtree_contains_one){//if '1' at right was TRUE - PRUNE RIGHT subtree
            node.right = null;
        }

        return node.val == 1 // so if '1' occured then true
                || left_subtree_contains_one // recursive check for '1' occured
                || right_subtree_contains_one;
    }
}
