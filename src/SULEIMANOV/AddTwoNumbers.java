package SULEIMANOV;

/*
add two numbers from list nodes
3 - 2 - 1    LisNode 1 - written backwards
5 - 9 - 2    LisNode 1 - written backwards

123  +  295 =  418

res   8 - 1  - 4  - res as list node backwards
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l11 = new ListNode(2);
        ListNode l111 = new ListNode(1);

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(9);
        ListNode l222 = new ListNode(2);

        l1.next = l11;
        l11.next = l111;

        l2.next = l22;
        l22.next = l222;

        ListNode res = addTwoNums(l1, l2);
        System.out.println(res);
    }

    public static ListNode addTwoNums(ListNode ln1, ListNode ln2) {
        ListNode result = new ListNode(0);//future result head placeholder
        ListNode l1_pointer = ln1, l2_pointer = ln2, currentNode = result;

        int dozenCarrier = 0;

        while (l1_pointer != null || l2_pointer != null) {//mind OR

            //check for each since OR - one of em can be null
            int l1_value = (l1_pointer != null) ? l1_pointer.val : 0;
            int l2_value = (l2_pointer != null) ? l2_pointer.val : 0;

            int sum = l1_value + l2_value + dozenCarrier; //sum of both and carried from before tenth carrier

            dozenCarrier = sum / 10;//carry tenth over
//current was pointing to head as a placeholder , initialize first node
            currentNode.next = new ListNode(sum % 10);// new node attached to placeholder with new value without tenth carrier
            currentNode = currentNode.next;//switch to next Node


            if (l1_pointer != null) {
                l1_pointer = l1_pointer.next;//shift to next
            }

            if (l2_pointer != null) {
                l2_pointer = l2_pointer.next;//shift to next
            }

            if (dozenCarrier > 0) {//if af ter all traversed dozen carrier still more than  0
                currentNode.next = new ListNode(dozenCarrier);//put it in brand new dedicated leading node
            }
        }
//remember res is placeholder - actual nodes are after , so NEXT
        return result.next;
    }
}
