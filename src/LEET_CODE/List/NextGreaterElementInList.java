package LEET_CODE.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
given list make array of of next larger element in list
2 1 5 3
5 5 0 0
since no bigger fro 5 and 5
 */
public class NextGreaterElementInList {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3 ;
        node3.next = node4;

        int[] res = nextLargerNodes(node1);

        System.out.println(Arrays.toString(res));


    }


    static int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> node_vals = new ArrayList<>();//store values of nodes
        ListNode currrent_node = head;//pointer to List

        while (currrent_node != null) {//populate node vals as we traverse the  list
            node_vals.add(currrent_node.val);
            currrent_node = currrent_node.next;//move to next traversal
        }

        int[] result = new int[node_vals.size()];//res
        Stack<Integer> element_indexes_stack = new Stack<>();//stack to track prev index

        for (int i = 0; i < node_vals.size(); i++) {

            while (!element_indexes_stack.isEmpty() // while smth in stack AND
                    && node_vals.get(element_indexes_stack.peek()) < node_vals.get(i)) {//node val by index from stack LESS then current val

                result[element_indexes_stack.pop()] = node_vals.get(i);//add to resa
            }
            element_indexes_stack.push(i);//add to stack ( so first while will no work - only at second iteration i =2

        }

        return result;
    }
}
