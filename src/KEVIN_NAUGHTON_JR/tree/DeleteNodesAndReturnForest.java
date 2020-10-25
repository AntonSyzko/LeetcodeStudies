package KEVIN_NAUGHTON_JR.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
given list of nodes to delete - delete em and retrun remained nodes as list

going from bottom UP is the approach , othervise deleting parent will loose refences to any children
going from bottom UP we can check if children has parent , and if parent is to DEL - children can go to remained nodes
 */

//O(n)  space O(N)
public class DeleteNodesAndReturnForest {

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


        List<TreeNode> remainedAfterDEletion = deleteNodes(root, new int [] {9, 20});
        System.out.println(remainedAfterDEletion);
    }

    static List<TreeNode> deleteNodes(TreeNode root, int [] to_delete){
        List<TreeNode> remainings = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();

        for (int i : to_delete){//populate SET of what has to be deleted
            toDelete.add(i);
        }

        removeNodes(root, toDelete, remainings);//recursion below

        if( !toDelete.contains(root)){//actual VERY root of the entire tree check , if it NOT has to be deleted
            remainings.add(root);//add to remaiings
        }

        return remainings;
    }

    private static TreeNode removeNodes(TreeNode root, Set<Integer> toDelete, List<TreeNode> remainings) {
 //base case , here eather the very bottom of tree, no place to recurse, or deleted item ( mindingf children got saved before item marked null( deleted )
        if( root == null){
            return null;
        }

        root.left = removeNodes(root.left, toDelete, remainings);//recurse on left side
        root.right = removeNodes(root.right, toDelete, remainings);//recurse on right side

        if( toDelete.contains(root.val)){//if current node is in list of to be deleted
//we came  bottom UP , so we have passed already the children level, here we check if node's to delete  child exists
            if(root.left != null){//node has left child, after deleteion , left child will be  lost
                remainings.add(root.left);//so add to remainings
            }

            if( root.right != null){//after deleteion right child will be lost - add to remainings
                remainings.add(root.right);
            }
//before this point all the c chuldren of node to be deleted has to be saved in remainings
            return null;// actual deletion - returning null hits base case recursion stops , no more further YP traversing the tree
        }

        return root;//here if toDel does not contain current val opf root - return itself - continue traversing ( checking it's lefts and rights )
    }
}
