package LEET_CODE.tree_traversals;

import java.util.*;

public class PostOrder {
    public static void main(String[] args) {


        Node root = new Node(1 );

        Node firstLeft = new Node(2);
        Node firstRight = new Node (3);

        Node secondFirstLeft = new Node(4);
        Node secondFirstRight = new Node (5);



        root.setChildren(List.of(firstLeft, firstRight));
        firstLeft.setChildren(List.of(secondFirstLeft, secondFirstRight));



        List<Integer> postOrder = portOrderWithStack(root);
        System.out.println(postOrder);


    }

    static List<Integer> portOrderWithStack(Node root){
        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();

        if( root == null) return output;
        stack.push(root);

        while (!stack.isEmpty()){
            Node current = stack.pop();
            output.addFirst(current.val);

            if(current.children != null){
                current.children.stream().forEach(child -> stack.push(child));
            }
        }
    return output;
    }



    static List<Integer> postOrderTraversal(Node root) {

      LinkedList<Node> stack = new LinkedList<>();
      LinkedList<Integer> output_array = new LinkedList<>();

      stack.add(root);

      //  32     1               - 1
      //3                     - 3
        //2 (5 4 )            - 2
        // 5                    - 5
        // 4 -----                  -4
      while (!stack.isEmpty()){
          Node currentInStack = stack.pollLast();//from top of stack
          output_array.addFirst(currentInStack.val);//to beginning of output - first will move to right - moving the root to end
          if(currentInStack.children != null){//no originally - but to avoid NPE
              for(Node child: currentInStack.children){
                  stack.addLast(child);//to the top of stack
              }
          }
      }
      return output_array;


    }






    static class Node {
        int val;
        List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }

        public List<Node> getChildren() {
            return children;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", \r\n " +
                    "children=" + children + '}';
        }
    }
}
