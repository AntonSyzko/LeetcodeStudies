package LEET_CODE.List;

/*
1 2 3 4
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {

    }

    static ListNode removeNth(ListNode head, int positionToRemove){
        ListNode dummy_head = new ListNode(0);//dummy pointer to head
        dummy_head.next = head;

        ListNode slow = dummy_head;
        ListNode fast = dummy_head;

        for (int i = 1; i <=positionToRemove+1 ; i++) {
            fast = fast.next;//move fast to one after needed position
        }

        while (fast != null){//if still to traverse
            slow = slow.next;//start moving next
            fast = fast.next;//again move fast till reached null
        }

        //by this time slow will be at postion before removal - assing to next next
        slow.next = slow.next.next;

        return dummy_head.next;//points to head
    }
}
