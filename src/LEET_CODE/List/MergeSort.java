package LEET_CODE.List;

public class MergeSort {


    public static void main(String[] args) {
        ListNode first = new ListNode(4);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(1);

        first.next = second;
        second.next = third;
        third.next = forth;

        System.out.println(first);

        ListNode sorted = sortList(first);

        System.out.println(sorted);
    }
    static ListNode sortList(ListNode head){
        if( head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            temp = slow;//placeholder for tail of left side
            slow = slow.next;//at the end stops at half
            fast = fast.next.next;//at the end stops at the end
        }

        temp.next = null;//tail of left side - NEXT is null ( end of sub_list kinda ) , cut off

        ListNode left_unsorted_side_head = sortList(head);//stopped at half, head pointed to temp, and temp to slow - so stopped at slow ( middle )
        ListNode right_unsorted_side_head  = sortList(slow);//started at half and stopped at end

        return merge(left_unsorted_side_head, right_unsorted_side_head);
    }

    private static ListNode merge(ListNode left_unsorted_side, ListNode right_unsorted_side) {
        ListNode sorted_temp = new ListNode(0);//placeholder
        ListNode current_node = sorted_temp;

        while (left_unsorted_side != null && right_unsorted_side !=null){//actual sorting

            if(left_unsorted_side.val < right_unsorted_side.val){//compare vals of sides
                current_node.next = left_unsorted_side;//append to current
                left_unsorted_side = left_unsorted_side.next;//shift inside left side
            } else {
                current_node.next = right_unsorted_side;
                right_unsorted_side = right_unsorted_side.next;
            }
            current_node = current_node.next;//raversal shift the very current
        }

        if( left_unsorted_side != null){//if left overs from left
            current_node.next = left_unsorted_side;//append rest
            left_unsorted_side = left_unsorted_side.next;//shift
        }

        if( right_unsorted_side != null){//if leftovers from right
            current_node.next = right_unsorted_side;//append rest
            right_unsorted_side = right_unsorted_side.next;//shift
        }

        return sorted_temp.next;//next cause head is just a placeholder
    }
}
