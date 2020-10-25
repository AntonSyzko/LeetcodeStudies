package KEVIN_NAUGHTON_JR.tree;


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) { this.val = val;}

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
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
