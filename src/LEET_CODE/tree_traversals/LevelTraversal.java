package LEET_CODE.tree_traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelTraversal {

    public static void main(String[] args) {
        Node root = new Node(1 );
        Node firstLeft = new Node(2);
        Node firstRight = new Node(3);

        Node secondFirstLeft = new Node(4);
        Node secondFirstRight = new Node(5);

        root.left = firstLeft;
        root.right = firstRight;
        firstLeft.left = secondFirstLeft;
        firstLeft.right = secondFirstRight;

        List<List<Integer>> levelTraversed = levelTraversal(root);
        System.out.println(levelTraversed);

    }

    static List<List<Integer>> levelTraversal (Node root){
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> que = new LinkedList<>();
        que.add(root);

        if(root == null) return res;//pre check

        while (!que.isEmpty()){
            List<Integer> level_array= new ArrayList<>();
            int level_size = que.size();

            while (level_size != 0){//while there is smth in level

                Node curr = que.poll();
                level_array.add(curr.val);

                if(curr.left!= null){//add to que - left childs
                    que.add(curr.left);
                }
                if(curr.right != null){
                    que.add(curr.right);
                }

                level_size--;//counter --
            }
            if(!level_array.isEmpty()){//if smth was added to level array - add to res
                res.add(level_array);
            }

        }
        return res;

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
