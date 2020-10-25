package HACKER_RANK.linked_list;

import java.util.Stack;

public class PrintInReverseLinkedList {

    static void printListInReversedOrder(SinglyLinkedListNode head){
        if(head==null)return;

        SinglyLinkedListNode current_node = head;

        Stack<SinglyLinkedListNode> stack = new Stack<>();

        while (current_node != null){
            stack.add(current_node);
            current_node=current_node.next;
        }

        while (!stack.isEmpty()){
            SinglyLinkedListNode node = stack.pop();
            System.out.println(node.val);
        }
    }

    static void printListInOrder(SinglyLinkedListNode head){
        if(head == null) return;

        SinglyLinkedListNode current_node = head;
        while (current_node != null){
            System.out.println(current_node.val);
            current_node = current_node.next;
        }

        return;
    }



    static class SinglyLinkedListNode {
        int val;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int val, SinglyLinkedListNode next) {
            this.val = val;
            this.next = next;
        }

        public SinglyLinkedListNode(int val) {
            this.val = val;
        }

        public void setNext(SinglyLinkedListNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "SinglyLinkedListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
