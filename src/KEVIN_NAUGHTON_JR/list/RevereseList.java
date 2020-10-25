package KEVIN_NAUGHTON_JR.list;

import LEET_CODE.List.ListNode;

/*
prev    1 -> 2 -> 3 -> null

prev <- 3 <- 2 <- 1
 */
public class RevereseList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        System.out.println("original \r\n "+n1);

        ListNode reversed = reverseList2(n1);
        System.out.println(reversed);

    }

    static ListNode reverseList(ListNode head){
        if( head == null) {
            return head;//base check - maybe  in condition, not necessary
        }

        ListNode prev = null;//initially empty, but will be  HEAD of future reversed list

        while (head != null){

            ListNode next_node = head.next;//pointer to initial next ( to 2 , 3 )

            head.next = prev;// turn the pointer backwards here , so 1 points to null, 2 to 1 , 3 to 2 - reverse

            prev = head;//now, after reverse of pointers, move prev to head, to continue reassigning

            head = next_node;//head traverses as original ( and swapping pointers, and moving prev as it goes, see above two lines )
        }

        return prev;//!!!!!! now points to new HEAD of reversed list
    }

    static ListNode reverseList2(ListNode head){
        ListNode prev = null;

        while (head != null){
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }

        return prev;
    }

    }
