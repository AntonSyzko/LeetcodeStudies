package HACKER_RANK.linked_list;

public class InsertNewNodeToTail_or_Head_of_list {


    static SinglyLinkdedList insertNodeToTail(SinglyLinkdedList head, int value){
        SinglyLinkdedList new_node = new SinglyLinkdedList(value);
        if(head == null) return new_node;

        SinglyLinkdedList current_node = head;

        while (current_node.next !=null){
            current_node = current_node.next;
        }
        current_node.next = new_node;
        return head;
    }



    static SinglyLinkdedList insertNodeToHead(SinglyLinkdedList head, int value){
        SinglyLinkdedList new_node = new SinglyLinkdedList(value);
        if(head==null) return new_node;

        new_node.next = head;
        return new_node;
    }




        static class SinglyLinkdedList {
        int val;
        SinglyLinkdedList next;

        public SinglyLinkdedList(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("SinglyLinkdedList{");
            sb.append("val=").append(val);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }
}
