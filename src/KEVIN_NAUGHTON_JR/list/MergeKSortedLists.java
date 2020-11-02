package KEVIN_NAUGHTON_JR.list;


import SULEIMANOV.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
given K sorted lists - merge em into one sorted
1 4 5
1 3 4
2 6

res 1 1 2 3 4 4 5 6



 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode one1 = new ListNode(1);
        ListNode one2 = new ListNode(4);
        ListNode one3 = new ListNode(5);

        ListNode two1 = new ListNode(2);
        ListNode two2 = new ListNode(3);
        ListNode two3 = new ListNode(4);

        one1.next = one2;
        one2.next = one3;

        two1.next = two2;
        two2.next = two3;

        ListNode[] lists = new ListNode[]{one1, two1};

        ListNode merged = mergeKSortedLists(lists);

        while (merged != null) {
            System.out.print(merged.val + " -> ");
            merged = merged.next;
        }

    }

    static ListNode mergeKSortedLists(ListNode[] lists) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();//MIN heap to store and sort ALL nodes

        for (ListNode head : lists) {//traverse ALL list nodes of all lists

            while (head != null) {//while smth to traverse within EACH list itself

                minHeap.add(head.val);//add each and evey to min heap

                head = head.next;//move on in traversal
            }
        }

        ListNode dummyPointer = new ListNode(-1);//dummy
        ListNode head = dummyPointer;//new head

        while (!minHeap.isEmpty()) {//while min heap has smth

            head.next = new ListNode(minHeap.remove());//extract from min heap and add to new list

            head = head.next;//traverse in new lest - move on
        }

        return dummyPointer.next;
    }
}
