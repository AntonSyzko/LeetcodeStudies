package LEET_CODE.List;



public class MiddleOfList {

    public static void main(String[] args) {

    }

    static ListNode getMiddleOfList(ListNode head){
        if(head==null) return head;
        ListNode slow_pointer = head;//start at same
        ListNode fast_pointer = head;//but fast will move twice faster

        while (fast_pointer != null && fast_pointer.next !=null){//till fast ends, it ends twice faster than slow
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;//twice faster - when riches end - slow will be at half
        }

        return slow_pointer;//slow stopped at middle, cause fast reached end twice faster -> end/2 = middle
    }
}
