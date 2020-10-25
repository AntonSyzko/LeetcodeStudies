package LEET_CODE.tree_traversals;

import java.util.Stack;

public class PathSum {

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

        boolean pathToSumExists = pathToGivenSumExistsInTree(root, 8);
        System.out.println(pathToSumExists);
    }


    static boolean pathToGivenSumExistsInTree(Node root, int sum){

        if( root == null) return false;

        Stack<Node> tree_node_stack = new Stack<>();//track nodes as we traverse
        Stack<Integer> sumStack = new Stack<>();//store sum - current sum of node and if we rich end and diff is zero - true

        tree_node_stack.add(root);
        sumStack.add(sum-root.val);//decrease straight away - cause root value already counts in

        while (!tree_node_stack.isEmpty()){
            Node currentNode = tree_node_stack.pop();
            int current_sum = sumStack.pop();

            if(currentNode.left == null && currentNode.right == null && current_sum==0){//last leaf and sum was decremented to zero - we have a match
                return true;
            }

            if(currentNode.left != null){
                tree_node_stack.add(currentNode.left);
                sumStack.add(current_sum-currentNode.left.val);
            }

            if(currentNode.right != null){
                tree_node_stack.add(currentNode.right);
                sumStack.add(current_sum-currentNode.right.val);
            }
        }

        return false;
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
