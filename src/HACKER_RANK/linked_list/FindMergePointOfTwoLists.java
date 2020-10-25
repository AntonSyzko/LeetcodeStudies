package HACKER_RANK.linked_list;
/*and compare finding same in both is the merge */
public class FindMergePointOfTwoLists {

    public static void main(String[] args) {
        SinglyLinkedListNode head1 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode head11 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode head111 = new SinglyLinkedListNode(55);
        SinglyLinkedListNode head1111 = new SinglyLinkedListNode(555);
        head1.setNext( head11);
        head11.setNext(head111);
        head111.setNext (head1111);




        SinglyLinkedListNode head2 = new SinglyLinkedListNode(6);
        SinglyLinkedListNode head22 = new SinglyLinkedListNode(55);
        SinglyLinkedListNode head222 = new SinglyLinkedListNode(555);
        head2.setNext (head22);
        head22.setNext (head222);
        int mergingPoint = findMergePointOfTwoLists(head1, head2);
        System.out.println(mergingPoint);
    }

    static int findMergePointOfTwoLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2){
        SinglyLinkedListNode head1_current = head1;
        SinglyLinkedListNode head2_current = head2;
        while (head1_current != head2_current){ // traverse while nodes are different
            if(head1_current.next ==null){//head1 finished
                head1_current = head2; // attach head2 to end
            }else {
                head1_current = head1_current.next;//move on
            }
            if(head2_current.next ==null){//head2 over
                head2_current = head1;//attach head1 to the end
            }else {
                head2_current = head2_current.next;//move on
            }
        }

        return head1_current.data;//after while exited head1 and  head2 were same - so any of them can by returned
    }
}
