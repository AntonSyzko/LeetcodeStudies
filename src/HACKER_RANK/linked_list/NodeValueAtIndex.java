package HACKER_RANK.linked_list;

public class NodeValueAtIndex {

    public static void main(String[] args) {

        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        SinglyLinkedListNode first = new SinglyLinkedListNode(2);
        SinglyLinkedListNode sec = new SinglyLinkedListNode(3);
        SinglyLinkedListNode third = new SinglyLinkedListNode(4);

        head.setNext(first); first.setNext(sec); sec.setNext(third);

        int node_data_at_position = getNodeValueAtPositionFromTail(head, 2);
        System.out.println(node_data_at_position);

    }

    static int getNodeValueAtPositionFromTail(SinglyLinkedListNode head, int positionFromTail){
        SinglyLinkedListNode pointer_node = head;
        int counter = 0;

        while (head != null){
            if(counter < positionFromTail){
                counter++;//counter increments only till less than position
            }else {
                pointer_node = pointer_node.next;//after count equals position - pointer_node starts to move and stops at needed node when list is over
            }
            head = head.next;//usual traversing list
        }

        return pointer_node.getData();
    }
}
