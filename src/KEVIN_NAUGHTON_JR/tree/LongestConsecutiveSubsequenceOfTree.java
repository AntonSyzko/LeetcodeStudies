package KEVIN_NAUGHTON_JR.tree;

/*
consecutive 1 - 2 - 3  and only downwards
 */
public class LongestConsecutiveSubsequenceOfTree {
    public static void main(String[] args) {

    }

    static int longestConsecutiveSubarray(TreeNode root){
        /*
 array - cause array is object - located in heap and available for all recursive calls,
  since recursion resides in stack and mere int wont be shared amongst recursive calls
  */
        int [] max_consecutive_subtree_length = new int [1];
        findLongestConsecutiveSubarraySequence(root, 0,0, max_consecutive_subtree_length);
        return max_consecutive_subtree_length[0];

    }

    private static void findLongestConsecutiveSubarraySequence(TreeNode root, int consecutive_count, int target_value, int[] max_consecutive_subtree_length) {
        if(root == null){//base case - loop over - reached end - root is null - stop
            return;
        }else if(root.val== target_value){//if current root val is our target val ( current val + 1 - since consecutive)
            consecutive_count++;
        }else {
            consecutive_count=1;//othervise - non consecutive = and count stays 1
        }
        max_consecutive_subtree_length[0] = Math.max(max_consecutive_subtree_length[0], consecutive_count);//choose max and reassign if needed


        //recursion  left leaf, current max conscutive count, target = current root +1
        findLongestConsecutiveSubarraySequence(root.left, consecutive_count,root.val+1, max_consecutive_subtree_length);
        //recursion right leaf, current max conscutive count, target = current root +1
        findLongestConsecutiveSubarraySequence(root.right, consecutive_count, root.val+1, max_consecutive_subtree_length);
    }
}
