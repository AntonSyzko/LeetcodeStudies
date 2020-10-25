package LEET_CODE.List;



public class SwapNodePairs {

    public static void main(String[] args) {

    }


    static ListNode swapNodePairs(ListNode head){
        ListNode temp_node = new ListNode(0);//temp placeholder
        temp_node.next = head;//head reference
        ListNode current_node = temp_node;//to use in traversal


        while (current_node.next !=null && current_node.next.next !=null){//while smth to traverse
            ListNode first_node = current_node.next;//head in beginning
            ListNode second_node = current_node.next.next;//second after head in beginning

            first_node.next = second_node.next;//jump in two

            current_node.next = second_node;//swap , used to be first - but now points to second
            current_node.next.next = first_node;//swap , since before first was reassigned to sec.next
            current_node = current_node.next.next;//traverse - in two
        }

        return temp_node.next;//head pointer returned
    }
}
