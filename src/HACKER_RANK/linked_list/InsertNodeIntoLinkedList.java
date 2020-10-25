package HACKER_RANK.linked_list;

public class InsertNodeIntoLinkedList {

    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        SinglyLinkedListNode sec = new SinglyLinkedListNode(2);
        SinglyLinkedListNode third =  new SinglyLinkedListNode(3);
        head.setNext(sec);
        sec.setNext(third);

        System.out.println(" list before  insertion :" + head);

        SinglyLinkedListNode listAfterInsertion = insertNodeToPosition(head,4,2);
        System.out.println(" list after insertion " + listAfterInsertion);

    }

    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position){
        if(head==null) return head;

        if(position == 0) return head.next;//if first - then next will retun null and no head thus

        SinglyLinkedListNode current_node = head;
        int count = 0;//to get to pistion with next

        while (count <= position-1){//-1 to stop one before we wanna delete
            current_node = current_node.next;
            count++;
        }

        current_node.next = current_node.next.next;//delete one in between -> .next.next - reassigned

        return head;
    }

    static SinglyLinkedListNode insertNodeToPosition(SinglyLinkedListNode head, int data, int position){

        SinglyLinkedListNode current = head;
        SinglyLinkedListNode nodeToInsert = new SinglyLinkedListNode(data);
        int index = 0;

        while (index < position-1){
            current = current.next;
            index ++;
        }

        nodeToInsert.next = current.next;
        current.next = nodeToInsert;


        return head;
    }



}
