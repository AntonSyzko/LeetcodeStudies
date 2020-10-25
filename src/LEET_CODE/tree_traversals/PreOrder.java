package LEET_CODE.tree_traversals;

import java.util.*;

public class PreOrder {

    public static void main(String[] args) {
        Node root = new Node(1 );

        Node firstLeft = new Node(2);
        Node firstRight = new Node(3);

        Node secondFirstLeft = new Node(4);
        Node secondFirstRight = new Node(5);



        root.setChildren(List.of(firstLeft, firstRight));
        firstLeft.setChildren(List.of(secondFirstLeft, secondFirstRight));



        List<Integer> postOrder = preOrderTraversal(root);
        System.out.println(postOrder);

    }

    static List<Integer> preOrderTraversal (Node root){
     LinkedList<Node> nodeStack = new LinkedList<>();
     LinkedList<Integer> output = new LinkedList<>();

     if( root==null) return output;
     nodeStack.add(root);

     while (!nodeStack.isEmpty()){
         Node curr = nodeStack.pollLast();
         output.add(curr.val);
          Collections.reverse(curr.children);//fails  here - but ok in leetcode

         if(curr.children != null){
             for (Node child : curr.children){
                 nodeStack.add(child);
             }

         }

     }
    return output;
    }




    static class Node {
        int val;
        List<Node> children;

        public Node(int val) {
            this.val = val;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", \r\n " +
                    "children=" + children + '}';
        }
    }
}
