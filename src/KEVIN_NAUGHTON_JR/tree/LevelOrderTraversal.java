package KEVIN_NAUGHTON_JR.tree;

import java.util.*;
import java.util.stream.Collectors;

/*
classic BST - use  QUEUE
 */
public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode f_left = new TreeNode(2);//leaf
        TreeNode f_rigth = new TreeNode(3);

        TreeNode ss_left = new TreeNode(5);//leaf

        root.left = f_left;
        root.right = f_rigth;
        f_left.right = ss_left;

        List<List<Integer>> levelsOfTree = levelOrderTraverse(root);

        System.out.println(levelsOfTree.stream().flatMap(Collection::stream).collect(Collectors.toList()));

    }

    static List<List<Integer>> levelOrderTraverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {//pre check
            return result;
        }

        Queue<TreeNode> bstQueue = new LinkedList<>();//BST
        bstQueue.add(root);//root checked - add to que

        while (!bstQueue.isEmpty()) {//while smth to iterate over
            int sizeOfQueForCurrentIteration = bstQueue.size();//size of que fro this iteration
            List<Integer> currentLevelNodes = new ArrayList<>();//current level results

            for (int i = 0; i < sizeOfQueForCurrentIteration; i++) {//as many iters acs size of que
                TreeNode currentNode = bstQueue.remove();//extract Node
                currentLevelNodes.add(currentNode.val);//add to level res

                if (currentNode.left != null) {//if left leaves - add to QUE to process on following iterations
                    bstQueue.add(currentNode.left);
                }

                if (currentNode.right != null) {//if right  leaves
                    bstQueue.add(currentNode.right);// - add to QUE to process on following iterations
                }
            }
            result.add(currentLevelNodes);//all level results go to final res
        }
        return result;
    }
}
