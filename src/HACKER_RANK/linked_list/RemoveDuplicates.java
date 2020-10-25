package HACKER_RANK.linked_list;

public class RemoveDuplicates {

    public static void main(String[] args) {

    }

    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head){
        if(head == null) return head;

        SinglyLinkedListNode new_head = head;//pointer to head - and new head as result - cause just using head will return itself unchanged

        while (head.next != null){//while smth to traverse
            if(head.data == head.next.data){//if dupliacte
                head.next = head.next.next;//omit dupliacte - set to next.next  and do it till all duplictaes traversed
            }else{
                head = head.next;//duplicates over ( oly in this case )  - move on in head
            }
        }

        return new_head;//new head was pointing to modifies haed
    }
}
