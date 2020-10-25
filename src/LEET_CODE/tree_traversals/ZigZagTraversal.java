package LEET_CODE.tree_traversals;

import java.util.*;

public class ZigZagTraversal {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node firstLeft = new Node(2);
        Node firstRight = new Node(3);

        Node secondFirstLeft = new Node(4);
        Node secondFirstRight = new Node(5);

        root.left = firstLeft;
        root.right = firstRight;
        firstLeft.left = secondFirstLeft;
        firstLeft.right = secondFirstRight;

        List<List<Integer>> levelTraversed = zigZagTraversal(root);
        System.out.println(levelTraversed);

    }

    static List<List<Integer>> zigZagTraversal(Node root) {
        if (root == null) return null;

        List<List<Integer>> res = new ArrayList<>();
        int level = 0;

        zigZagHelper(root, level, res);
        return res;

    }


    static void zigZagHelper(Node root, int level, List<List<Integer>> res) {
        if(root == null) return;

        if(res.size() < level+1){
            res.add(new LinkedList<Integer>());//add emty array to store level values
        }
        if(level % 2 == 0){
            res.get(level).add(root.val);
        }else{
            res.get(level).add(0, root.val);
        }

        zigZagHelper(root.left,level +1, res);
        zigZagHelper(root.right,level +1, res);


    }


    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", left=" + left + ", right=" + right + '}';
        }
    }
}
