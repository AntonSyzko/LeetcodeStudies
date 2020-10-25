package KEVIN_NAUGHTON_JR.tree;



import LEET_CODE.List.ListNode;
import LEET_CODE.List.RevereseLinkedList;

import java.util.HashSet;
import java.util.Set;

/*
given two singly linked lists intersection
find intersection start node
or null if no

789456
12456
456 is common, 4 - is intersection start
 */
public class TwoListsIntersection {
    public static void main(String[] args) {

    }

    static ListNode listIntersection(ListNode head1, ListNode head2){
        Set<ListNode> setOfFirstListNodes = new HashSet<>();
        while (head1 != null){//while smth to traverse in list 1
            setOfFirstListNodes.add(head1);//store in set
            head1 = head1.getNext();//trvaerse
        }

        while (head2 != null){//while smth to traverse in list 2
            if(setOfFirstListNodes.contains(head2)){//if already in list 1
                return head2;//so it was an intersection, no matter how ling at least 1 and sterted here
            }
            head2 = head2.getNext();//traverse list 2
        }

        return null;//did not return above - NO intersection - nULL
    }
}
