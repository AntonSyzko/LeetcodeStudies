package LEET_CODE.tree_traversals;

public class MaxDepthOfBinaryTree {

    public static void main(String[] args) {

    }

    static int max_depth = 0;

    //top bottom
    static void maxDepthOfBinTree(Node root, int depth) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            max_depth = Math.max(max_depth, depth);
        }

        maxDepthOfBinTree(root.left, depth + 1);
        maxDepthOfBinTree(root.right, depth + 1);
    }

    //bottom down
    static int maxDepthOfBinTree(Node root) {
        if (root == null) return 0;
        int left_depth = maxDepthOfBinTree(root.left);
        int right_depth = maxDepthOfBinTree(root.right);

        return Math.max(left_depth, right_depth) + 1;//+1 include current level
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
