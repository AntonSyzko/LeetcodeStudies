package LEET_CODE.tree_traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

    public static void main(String[] args) {
        Node root = new Node(1 );

        Node firstLeft = new Node(2);
        Node firstRight = new Node (3);

        Node secondFirstLeft = new Node(4);
        Node secondFirstRight = new Node (5);

       root.left = firstLeft;
       root.right = firstRight;
       firstLeft.left = secondFirstLeft;
       firstLeft.right = secondFirstRight;

       List<Integer> in_order_traversed = inOrderTraversal(root);
        System.out.println(in_order_traversed);

    }

        static List<Integer> inOrderTraversal (Node root){
        Stack<Node> stack = new Stack<>();
        List<Integer> output_array = new ArrayList<>();

        if( root == null) return output_array;//pre check

        Node current = root;//to start with

        while (current != null || !stack.isEmpty()){//smth in curren OR in stack
            while (current != null){//traversing down - till current left null
                stack.push(current);
                current = current.left;//reassign current to it's left till null ( while )

            }

            current = stack.pop();//take last bottom left stored in stack
            output_array.add(current.val);//add to result - bottom left last node
            current = current.right;// all done with lefts - do right ( checking their lefts accordingly )
        }

        return output_array;
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
