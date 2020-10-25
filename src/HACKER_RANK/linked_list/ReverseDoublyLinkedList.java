package HACKER_RANK.linked_list;

public class ReverseDoublyLinkedList {


    static DoublyLinkedList reverse(DoublyLinkedList head) {
        DoublyLinkedList current = head;//link to head
        DoublyLinkedList new_head = head;//future response head

        while (current != null) {
            DoublyLinkedList prev = current.prev;//holder to prev - since we gonna loose the prev ref in reassigning(next line)
            current.prev = current.next;//rassign prev to next ( here prev lost lost its reference and now is next pointing)
            current.next = prev;//reassign next to prev, using holder
            new_head = current;//new head

            //mind !!! here current = current.next as usual wont do, since next is pointing to prev and we have to go on in original list
            current = current.prev;//since next is now pointing to prev - to traverse onwards one needs PREV ( it's now  pointing to NEXT )
        }

        return new_head;
    }


    static class DoublyLinkedList {
        int val;
        DoublyLinkedList next;
        DoublyLinkedList prev;


    }
}
