package LEET_CODE.tree_traversals;

public class SymmetricTree {

    public static void main(String[] args) {
       // isSymmetric//
    }
    
    static boolean isSymmetric(Node root){

        return isMirror(root, root);
    }

    private static boolean isMirror(Node t1, Node t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;

        return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }


    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("val=").append(val);
            sb.append(", left=").append(left);
            sb.append(", right=").append(right);
            sb.append('}');
            return sb.toString();
        }
    }
}
