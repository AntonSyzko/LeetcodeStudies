package KEVIN_NAUGHTON_JR.tree;


/*
given BST find lowers common acestro, vals 2, 8

       6
   2       8
 0   4    7  9

 2 and 8 are to left and right of 6 - so 6 is lowest common ancestor
 2 and 4 are at left - so 2 is lowest
 */
public class LowestCommonAncestor {

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(p.val < root.val && q.val < root.val){//if vals of P and Q are lower than root - so lowest common is at left subtree
            return lowestCommonAncestor(root.left, p,q);//recusively on left subtree
        } else  if (p.val > root.val && q.val > root.val){//if P and Q val > root - so lowest common at the right subtree
            return  lowestCommonAncestor(root. right, p,q);//resursively check Right subtree
        }else{//vals are at left AND right , not bot at left or both at right
            return  root;//root is lowest common - and this is a base  case of recursion
        }
    }
}
