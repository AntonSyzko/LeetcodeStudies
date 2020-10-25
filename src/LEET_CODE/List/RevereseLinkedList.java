package LEET_CODE.List;



public class RevereseLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode second =new ListNode(2);
        ListNode third =new ListNode(3);
        head.next = second;
        second.next = third;

        System.out.println(" original \r\n " + head);
        ListNode reversed = reverseLinkedList(head);
        System.out.println(" reversed \r\n "+reversed);
    }

    // null ...  1 -> 2 -> 3 -> null
    // null <- 1 <- 2 <- 3 .... null
    static ListNode reverseLinkedList(ListNode current){

        ListNode previous = null;
        
        while (current != null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
    // null .....  1 -> 2 -> 3 -> null
    //  null <- 1 <- 2 <- 3 ....null
    static ListNode reverseAList(ListNode current){

      ListNode previous = null;//points to nothing in the beginning

      while (current != null){
          ListNode next = current.next;// store next before removing pointer
          current.next = previous; // now pointer goes left to prev null <- 1  ....  2 -> 3 -> null
          previous = current; // shift right
          current = next; // shift right
      }

      return previous;//return last stored prev ( null <- 1 <- 2 <- 3(prev so far )  <- null )
    }

     static class ListNode {
        int value;
        ListNode next;
        public ListNode(int value) { this.value = value; }

         @Override
         public String toString() {
             return "{" + "value=" + value + ", next=" + next + '}';
         }
     }
}
