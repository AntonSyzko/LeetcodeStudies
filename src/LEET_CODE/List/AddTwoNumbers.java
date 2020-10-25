package LEET_CODE.List;

/*
add two nums, represented as linked lists
add them in reverse order

2 -> 4 -> 3
5 -> 6 -> 4

reverse order of each 342 + 465 = 807
output 7 -> 0 -> 8

1 2    8 9
21 + 98 = 119 res 9 -> 1 -> 1

 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode l1_f = new ListNode(2);
        head1.next = l1_f;

        ListNode head2 = new ListNode(8);
        ListNode l2_f = new ListNode(9);
        head2.next = l2_f;

        ListNode resSum = addTwoNumbers(head1, head2);

        System.out.println(resSum);
    }

    static ListNode addTwoNumbers(ListNode list1, ListNode list2){
        ListNode dummy_head = new ListNode(0);//just a fake head pointer to result
        ListNode list3 = dummy_head;//result

        int tenth_carry = 0;//cary additions over 10

        while (list1 != null || list2 != null){//while  any of list not null

            int list1_value = (list1 != null)? list1.val : 0;//list1 exists? get a value ? or if not - zero
            int list2_value = (list2 != null)? list2.val : 0;//lsit2 exists ? get a val or 0

            //sum of both vals and tenth carry to calculate new tenth carry
            int current_sum = list1_value + list2_value + tenth_carry;
            //carry afetr div by ten
            tenth_carry = current_sum/10;
            //last digit to store in new node of res
            int last_digit = current_sum % 10;

            //new node of future res
            ListNode new_node = new ListNode(last_digit);
            //next points to new node now, thus adding nodes to res as we calculate
            list3.next = new_node;

            //if list 1 still not null here
            if( list1 != null) list1 = list1.next;//move to it's NEXT node
            //if list 2 still not null here
            if( list2 != null)  list2 = list2.next;//move to it's NEXT node

            //set new pointer to head of result
            list3 = list3.next;
        }

        //if sum calc got carry tenth
        if( tenth_carry > 0){
            ListNode new_node = new ListNode(tenth_carry);//it will be the new node
            list3.next = new_node;//added last
            list3 = list3.next;//move new pointer anyways
        }

        return dummy_head.next;//dummy head next was set to list3 in the beginning
    }
}
