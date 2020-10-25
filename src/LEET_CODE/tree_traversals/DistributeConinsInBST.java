package LEET_CODE.tree_traversals;

/*
given num of coins on node - distribute coins evenly among all nodes
number of moves needed is abs val of all nodes + next ongoing node val - 1
 */
public class DistributeConinsInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode f_left = new TreeNode(0);
        TreeNode f_rigth = new TreeNode(3);
//        TreeNode ff_left = new TreeNode(7);
//        TreeNode ff_right = new TreeNode(0);
//        TreeNode ss_left = new TreeNode(0);
//        TreeNode ss_right = new TreeNode(0);
        root.left = f_left;
        root.right = f_rigth;
//        f_left.left = ff_left;
//        f_left.right = ff_right;
//        f_rigth.left = ss_left;
//        f_rigth.right = ss_right;

        int num_of_moves = movesNeededToDistributeCoins(root);
        System.out.println(num_of_moves);
    }

    static int numOfMoves;
    static int movesNeededToDistributeCoins(TreeNode root){
        numOfMoves = 0;
        give_coins(root);
        return numOfMoves;
    }

   private  static int  give_coins(TreeNode root) {
        if(root == null) return 0;//base case

        int left = give_coins(root.left);//steps taken on lefts side//here 0 + 0 -1 (cause we minus 1 below) = -1
        int right = give_coins(root.right);//right side // here 0 + 3 - 1 = 2
        numOfMoves += Math.abs(left) + Math.abs(right);//all moves//abs -1 + 2 = 3
        return root.val + left + right -1;//actual calc - current node val + val on next left + val on right and - 1 at the end
    }
}
