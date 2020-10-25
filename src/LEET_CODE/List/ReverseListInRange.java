package LEET_CODE.List;

/*
reverse between range ( ex 2 - 4 )
1 -> 2 -> 3 -> 4 -> 5
1 -> 4 -> 3 -> 2 -> 1
 */
public class ReverseListInRange {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next=n4;
        n4.next=n5;
        System.out.println(" original list : " + n1);
        ListNode reversedInRange = reverseInRange(n1,2,4);
        System.out.println(" reversed " + reversedInRange);

    }

    static ListNode reverseInRange(ListNode head, int start, int end){
        if( head == null) return null;//pre check


        ListNode prev = null;//init prev null
        ListNode current_node = head;//start at head

        while (start > 1){//while smth to decrement to start
            prev = current_node;//just move prev
            current_node = current_node.next;//and move current
            start--;//decrement start
            end--;//end decrements to be  like counter of staps to reverse after so 3 - 2 - 1
        }

        ListNode connection = prev;//to connect the remained start part to reversed afterwards
        ListNode tail = current_node;//to connect the remained tail to reversed part after

        while (end > 0){//while stpes to revert
            //regular reverse
            ListNode next_ref = current_node.next;
            current_node.next = prev;
            prev = current_node;
            current_node = next_ref;
            end--;//decrememt step
        }

        if( connection != null){//if before reversed part was connection
            connection.next = prev;//point next of connection to prev - which holds start of revered now
        }else {
            head = prev;//othervise was from start - and head is prev
        }

        tail.next = current_node;//connect remained tail


        return head;



    }
}
