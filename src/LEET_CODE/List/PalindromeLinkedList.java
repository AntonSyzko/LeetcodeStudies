package LEET_CODE.List;


public class PalindromeLinkedList {

    public static void main(String[] args) {

        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(3);
        ListNode fifth = new ListNode(2);
        ListNode sixth = new ListNode(1);
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = sixth;
        System.out.println(" linked list " + first);
        boolean isPalindrome = isPalindrome(first);
        System.out.println(" is palindorme " + isPalindrome);
    }

    static boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;//when fast is at the end
            slow = slow.next;//slow will be at the middle
        }


        slow = reverseHalfOfList(slow);//reverse from middle of list ( 3 -> 2 -> 1   to  3 <- 2 <- 1  )
        fast = head;// put fast to the beginning back for future comparising

        while (slow != null) {// slow was in middle - move till end

            if (fast.value != slow.value) {
                return false;
            }
            slow = slow.next;// just move on from middle to end
            fast = fast.next;//move to middle
        }
        return true;

    }

    static ListNode reverseHalfOfList(ListNode toReverse) {
        ListNode prev = null;

        while (toReverse != null) {
            ListNode next = toReverse.next;
            toReverse.next = prev;
            prev = toReverse;
            toReverse = next;
        }
        return prev;
    }


    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + "value=" + value + ", next=" + next + '}';
        }
    }
}
