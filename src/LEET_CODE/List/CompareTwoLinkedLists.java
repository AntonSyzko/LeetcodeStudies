package LEET_CODE.List;

import HACKER_RANK.linked_list.SinglyLinkedListNode;

public class CompareTwoLinkedLists {

    public static void main(String[] args) {

    }

    static boolean compareTwoListsIterative(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null && head2 == null) return true;//same nothing )))

        SinglyLinkedListNode first_runner = head1;//unnecessary - use  head possible
        SinglyLinkedListNode second_runner = head2;

        while (first_runner != null && second_runner != null) {//while smth to move

            if (first_runner.getData() != second_runner.getData()) {//actual content comparising
                return false; // or break; // will exit loop
            }
            if (first_runner.getNext() == null || second_runner.getNext() == null) {//if reached end and all was good - true
                return true;
            }


            first_runner = first_runner.getNext();//move on
            second_runner = second_runner.getNext();
        }

        return false;
    }

    static boolean compareTwoListsRecursive(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null && head2 == null) return true;
        if (head1 == null && head2 != null) return false;//either of nodes are null - false
        if (head1 != null && head2 == null) return false;//either of nodes are null - false
        if (head1.getData() != head2.getData()) return false;//actual data comparising
        return compareTwoListsRecursive(head1.getNext(), head2.getNext());//recur

    }

}
