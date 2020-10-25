package KEVIN_NAUGHTON_JR.list;

import LEET_CODE.List.ListNode;

/*
1 2 3 8
1 3 5

1 1 2 3 3 5 8
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(8);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode n11 = new ListNode(1);
        ListNode n22 = new ListNode(3);
        ListNode n33 = new ListNode(5);


        n11.next = n22;
        n22.next = n33;

        ListNode merged = mergeTwoSortedLists(n1, n11);
        System.out.println(merged);
    }

    static ListNode mergeTwoSortedLists(ListNode list1, ListNode list2){

        ListNode dummyNewListPointer = new ListNode(-1);//-1 is just to indicate that this FAKE DUMMY node is just a placeholder

        ListNode newHead = dummyNewListPointer; // future head, initially points to FAKE node above

        while (list1 != null && list2 != null){//while BOTH of lists are not NULL
            if(list1.val < list2.val){//choose smaller
                dummyNewListPointer.next = list1;//assign to new list next
                list1 = list1.next;//shift original list to poick next node
            }else {
                dummyNewListPointer.next = list2;
                list2 = list2.next;
            }

            dummyNewListPointer = dummyNewListPointer.next;//shift new list to assign next smaller of two as we traverse in while
        }

        if(list1 != null){//if list 1 after whle loop still has elements
            dummyNewListPointer.next = list1;//assign ALL of them in bulk to new list
        } else {
            dummyNewListPointer.next = list2;//or list 2 still has elements
        }
        return newHead.next;// the very head is DUMMY FAKE POINTER ( REMEMBER THAT ) - so next points to real node
    }
}
