package SULEIMANOV;

public class ConvertSortedArrayToBST {

    public static void main(String[] args) {
       int[] sorted = new int[]{1,2,3,4,5};
       TreeNode bst = convertToBST(sorted);
        System.out.println(bst);
    }

    static TreeNode convertToBST(int[] sorted){
        TreeNode root = buildBST(sorted, 0, sorted.length-1);
        return root;
    }

    private static TreeNode buildBST(int[] sorted, int start, int end) {
        if(start > end){//base case
            return null;
        }

        int midElement = start + (end-start)/2;//mid POSTION
        TreeNode midNode = new TreeNode(sorted[midElement]);//new node with value BY position
        midNode.left = buildBST(sorted, start, midElement-1);//left subtree construction
        midNode.right = buildBST(sorted, midElement+1, end);//right subtree construction

        return midNode;//retuen very constructed NODE 
    }
}
