package KEVIN_NAUGHTON_JR.tree;

public class ConvertSortedArrayToBinSearchTree {
    public static void main(String[] args) {
        int[] nums = new int [] {1,2,0,3,5};
       TreeNode fromArray = arrayToBST(nums);
        System.out.println(fromArray);
    }


    static TreeNode arrayToBST(int [] nums){
        if(nums == null || nums.length == 0 ){
            return null;
        }

        return constructBSTFromArray(nums, 0, nums.length-1);
    }

    private static TreeNode constructBSTFromArray(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }

        int mid = left + ( right-left)/2;
        TreeNode current = new TreeNode(nums[mid]);
        current.left = constructBSTFromArray(nums, left, mid-1);
        current.right = constructBSTFromArray(nums, mid+1, right);

        return current;
    }
}
