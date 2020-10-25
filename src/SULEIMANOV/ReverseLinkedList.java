package SULEIMANOV;

public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        System.out.println(n1);

        ListNode reversed = reverse(n1);

        System.out.println(reversed);



    }

    static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;

        while (current != null){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;//will contain link to new head in reverse order
    }
}
