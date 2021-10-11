package LEET_CODE.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
remove list node of given value
 */
public class RemoveLinkedListElement {

    @Test
    public void test() {
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(4);
        ListNode h4 = new ListNode(5);
        ListNode h5 = new ListNode(5);

        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;

        System.out.println(h1);

        ListNode res = removeLestNodeByValue(h1, 3);

        System.out.println(res);

        assertEquals(res.next.val, 4);

        ListNode afterDeletion  = deleteDuplicateNodesFromSortedList(h1);
        System.out.println(afterDeletion);
    }

    static ListNode removeLestNodeByValue(ListNode head, int val) {

        while (head != null && head.val == val) {//if head is OUR target straight from start
            head = head.next;//move  head to head next
        }

        ListNode current_node = head;

        //rest of list 
        while (current_node != null && current_node.next != null) {
            if (current_node.next.val == val) {
                current_node.next = current_node.next.next;
            } else {
                current_node = current_node.next;
            }
        }

        return head;
    }

    static ListNode deleteDuplicateNodesFromSortedList(ListNode head) {
        ListNode current_node = head;

        while (current_node != null && current_node.next != null) {
            if (current_node.val == current_node.next.val) {
                current_node.next = current_node.next.next;
            } else {
                current_node = current_node.next;
            }
        }

        return head;
    }

}
