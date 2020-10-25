package HACKER_RANK.linked_list;

public class ReverseLinkedList {

    public static void main(String[] args) {

        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        SinglyLinkedListNode sec = new SinglyLinkedListNode(2);
        SinglyLinkedListNode third = new SinglyLinkedListNode(3);
        head.setNext(sec);
        sec.setNext(third);

        System.out.println(" in order " + head);
        System.out.println(" reversed " + reverseLinkedList(head));
    }

    static SinglyLinkedListNode reverseLinkedList(SinglyLinkedListNode head){
        if(head == null) return head;
        SinglyLinkedListNode previous = null;
        SinglyLinkedListNode current_node = head;

        while (current_node !=null){
            SinglyLinkedListNode next_node = current_node.next;//store the val of next to assign later
            current_node.next = previous;//point to prev - reverse direction so to say
            previous = current_node;//move on prev
            current_node = next_node;//move on current
        }


        return previous;//now prew is the last of reversed list
    }
}
