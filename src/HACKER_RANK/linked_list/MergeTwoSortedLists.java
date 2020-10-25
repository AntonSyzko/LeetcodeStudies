package HACKER_RANK.linked_list;

public class MergeTwoSortedLists {


    static SinglyLinkedListNode mergeTwoLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2){
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        SinglyLinkedListNode final_head = null;

        if(head1.getData() < head2.getData()){//first node of new list choosing
            final_head = head1;
            head1 = head1.next;//next cause first already taken and assigned to new list head
        }else{
            final_head = head2;
            head2 = head2.next;
        }

        SinglyLinkedListNode cureent_node = final_head;//temp runner  node to work with

        while (head1 != null && head2 != null){//for moving on
            if(head1.getData() < head2.getData()){
                cureent_node.setNext(head1);
                head1 = head1.next;//move on in firts list
            } else {
                cureent_node.setNext(head2);
                head2 = head2.next;//move on in second list
            }
            cureent_node = cureent_node.next;//move on through the new list
        }

        if(head1 == null){//if one of the lists was smaller and there is some left overs to assign
            cureent_node.setNext(head2);
        }else {
            cureent_node.setNext(head1);

        }


        return final_head;
    }
}
