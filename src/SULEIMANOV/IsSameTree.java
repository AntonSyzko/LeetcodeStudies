package SULEIMANOV;

public class IsSameTree {

    public static void main(String[] args) {
   TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;


        TreeNode n11 = new TreeNode(1);
        TreeNode n12 = new TreeNode(2);
        TreeNode n13 = new TreeNode(3);
        n11.left = n12;
        n11.right = n13;

        boolean isSame = isSameTree(n1, n11);
        System.out.println(isSame);

    }

    static boolean isSameTree(TreeNode first, TreeNode second){
        if( first == null && second == null){//reached end here - both leafs end null
            return true;
        }

        if( first == null || second == null){// one OR other is null
            return false;
        }

        if( first.val != second.val){//vals done match 
            return false;
        }

        return isSameTree(first.left, second.left) && isSameTree(first.right, second.right);


    }
}
