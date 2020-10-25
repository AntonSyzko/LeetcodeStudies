package BACK_TO_BACK_SWE;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
serialize deserialize tree to string and back
don't use global state ( thjats why helper function is used , see below ))
 */
public class SerializeDesirielizeTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left= node2;
        node1.right = node3;

        String treeSerialized = serializeTree(node1);
        System.out.println(treeSerialized);

        TreeNode deserializedBack = deserializeToTree(treeSerialized);

        System.out.println(deserializedBack);



    }

    static String serializeTree(TreeNode root){

        if(root == null) return "X,";//recusive base case

        String leftSubtree = serializeTree(root.left);//recursion
        String rightSubtree = serializeTree(root.right);

        return root.val + "," + leftSubtree + rightSubtree;//aggregate recusive results , adding separator

    }

    static TreeNode deserializeToTree(String serialized){
        Queue<String> nodesLeft = new LinkedList<>();//que will store nodes as  we traverse
        nodesLeft.addAll(Arrays.asList(serialized.split(",")));

        return deserializedHelper(nodesLeft);
    }

    private static TreeNode deserializedHelper(Queue<String> nodesLeft) {
        //get current from top of QUEUE
        String currentNodeValue = nodesLeft.poll();
        //means end of branch - null - no more child nodes - no need to construct tree onwards
        if(currentNodeValue.equals("X")){
            return null;//recursion base case exit
        }
        //form a new node
        TreeNode newNode = new TreeNode(Integer.parseInt(currentNodeValue));

        //recursion will stop at X and paste NULL,
        newNode.left = deserializedHelper(nodesLeft);

        //rest of nodes in QUE will be automatically from RIGHT subtree
        newNode.right = deserializedHelper(nodesLeft);

        return newNode;

    }
}
