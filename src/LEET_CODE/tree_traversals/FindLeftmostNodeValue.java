package LEET_CODE.tree_traversals;

import java.util.LinkedList;
import java.util.Queue;

public class FindLeftmostNodeValue {



    static int leftmostNodeInLastRowValue(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//to start with smth

        while (!queue.isEmpty()){
            root = queue.poll();//reassigned root here , to what's in the queue first

            if(root.right != null){//all the rights will be inserted to queue first
                queue.add(root.right);
            }
            if(root.left != null){//then all the lefts
                queue.add(root.left);
            }
        }

        return root.val;//in te end there will be one lef LEFT and it's value is what we  need
    }
}
