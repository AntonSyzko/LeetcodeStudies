package KEVIN_NAUGHTON_JR.tree;
/*
given to trees - identify if structurally same
structurally means null refs are also same

so 1,2   is NOT same to 1,null,2

1,2,3 is same to 1,2,3
 */
public class AreTreesSame {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode f_left = new TreeNode(1);//leaf
        TreeNode f_rigth = new TreeNode(3);
        root.left = f_left;
        root.right = f_rigth;

        TreeNode root2 = new TreeNode(2);
        TreeNode f_left2 = new TreeNode(1);//leaf
        TreeNode f_rigth2 = new TreeNode(3);
        root2.left = f_left2;
        root2.right = f_rigth2;

        boolean isSame = isSameTree(root, root2);
        System.out.println(isSame);
    }


    static boolean isSameTree(TreeNode node1, TreeNode node2){
        if(node1 ==null && node2 == null){
            return true;
        }else if( node1 == null || node2 == null){
            return false;
        }else if( node1.val != node2.val){//recursion base case HERE
            return false;
        }else {
            return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
        }
    }
}
