package LEET_CODE.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
1 2 3 4 5
6 7 8 4 5   intersects at Node 4
 */
public class IntersectionOfTwoLinkedLists {

    @Test
    public void test(){
        ListNode a1 = new ListNode(1);
        ListNode a11 = new ListNode(2);
        a1.next = a11;

        ListNode b1 = new ListNode(4);
        b1.next = a11;

        ListNode intersection = intersection(a1, b1);
        System.out.println(intersection);
        assertEquals(intersection.val, 2);

    }


    static ListNode intersection(ListNode headA, ListNode headB){
        if(headA == null || headB == null){
            return null;
        }

        ListNode a_pointer = headA;
        ListNode b_pointer = headB;

        while (a_pointer  != b_pointer){

            if(a_pointer == null){
                a_pointer = headB;
            }else {
                a_pointer = a_pointer.next;
            }

            if(b_pointer == null){
                b_pointer = headA;
            }else {
                b_pointer = b_pointer.next;
            }
        }

        return a_pointer;
    }
}
