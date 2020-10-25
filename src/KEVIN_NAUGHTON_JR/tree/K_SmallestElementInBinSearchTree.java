package KEVIN_NAUGHTON_JR.tree;

public class K_SmallestElementInBinSearchTree {

    static int kSmallestElemenetInBST(TreeNode root, int k){
        int[] nums = new  int [2];//first is where are we in tree ( 1st smallest, 2nd) and second is value

        in_order_traversal(root, nums, k);

        return nums[1];
    }

    private static void in_order_traversal(TreeNode root, int[] nums, int k) {
        if( root == null) return;

        in_order_traversal(root.left, nums, k);//first reach the most left leaf
//in zero position is number of smallest ( first, sec, third ) and in position 1 is value 
        if(++nums[0]==k){//++ is cause we are one based in tree, so if its the k we need ,
            nums[1]=root.val;//store value of k-smallest in array
            return;//and thats it if the k matched
        }
        in_order_traversal(root.right, nums, k);//otherwise go to right leaf
    }
}
