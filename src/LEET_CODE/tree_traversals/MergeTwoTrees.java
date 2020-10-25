package LEET_CODE.tree_traversals;


public class MergeTwoTrees {


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode firstLeft1 = new TreeNode(2);
        TreeNode firstRight1 = new TreeNode(3);

        TreeNode secondFirstLeft1 = new TreeNode(4);
        TreeNode secondFirstRight1 = new TreeNode(5);

        root1.left = firstLeft1;
        root1.right = firstRight1;
        firstLeft1.left = secondFirstLeft1;
        firstLeft1.right = secondFirstRight1;

        TreeNode root2 = new TreeNode(10);
        TreeNode firstLeft2 = new TreeNode(20);
        TreeNode firstRight2 = new TreeNode(30);

        TreeNode secondFirstLeft2 = new TreeNode(40);

        root2.left = firstLeft2;
        root2.right = firstRight2;
        firstLeft2.left = secondFirstLeft2;

        TreeNode resMergerdTwoTrees = mergeTrees(root1, root2);
        System.out.println(resMergerdTwoTrees);

    }

    static TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if(t1 == null) return t2;
        if(t2 == null) return t1;

        t1.val += t2.val;

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        
        return t1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" + "val=" + val + ", left=" + left + ", right=" + right + '}';
        }
    }

}
