package LEET_CODE.tree_traversals;

import java.util.ArrayList;
import java.util.List;

/*
     1
  3    2
 5 3     9

 res [1,3,9]
 */
public class LargetsValueInTreeRow {
    public static void main(String[] args) {

    }

    static List<Integer> findLargestValuesInTreeLevels(TreeNode root) {
        List<Integer> largest_values_in_rows = new ArrayList<>();//res
        int level = 0; // intiail level
        depth_first_search(root, largest_values_in_rows, level);//recursion on each node of each level of row
        return largest_values_in_rows;


    }

    private static void depth_first_search(TreeNode node, List<Integer> largest_values_in_rows, int level) {

        if (node == null) return;//base case to exit recursion

//first level try - we are adding current node ( referenced as root here but means current  node, not root of tree )
        if (level == largest_values_in_rows.size()) {
            largest_values_in_rows.add(node.val);//first node in this entire row gets added
        } else {//but if there is smth in list for this row level already ( from above if ) , meaning from left or right tree leaf
            largest_values_in_rows.set(level, Math.max(largest_values_in_rows.get(level), node.val));//then compare current with new and choose  bigger
        }
        depth_first_search(node.left, largest_values_in_rows, level + 1);//level increases
        depth_first_search(node.right, largest_values_in_rows, level + 1);//so in list.size comparing to level works
    }
}
