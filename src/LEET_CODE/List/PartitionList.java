package LEET_CODE.List;

/*
given list and value x
partition list so that nodes with values < x come before nodes with values > x
 */
public class PartitionList {

    public static void main(String[] args) {

    }

    static ListNode partitionByPivot(ListNode head, int pivot){
        ListNode before_head = new ListNode(0);//just a kinda fake placeholder, pointer to our before list
        ListNode before = before_head;//actual before  list ( head created ahead, just to manipulate easily)
        ListNode after_head = new ListNode(0);//just a kinda fake placeholder, pointer to our after list
        ListNode after = after_head;//actual after  list ( head created ahead, just to manipulate easily)

        while (head != null){//treaverse original list
            if(head.val < pivot){
                before.next = head;//assign new val to before
                before = before.next;//shift before - traversal move on
            } else {
                after.next = head;// assign new val to our new after list
                after = after.next;//move on - shift after
            }

            head = head.next;//move on in original list, shift traverse
        }

        after.next = null;//end of our after, TAIL hAS TO POINT to NULL
        before.next = after_head.next;//end of before - so next of ot's end points to after ( but not the head, since head is fake placeholder )

        return before_head.next;//actual before , head was just a fale  placeoldfer
    }
}
