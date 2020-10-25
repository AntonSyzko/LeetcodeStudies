package HACKER_RANK.linked_list;

public class CyclicList {

    public static void main(String[] args) {


    }

    static boolean hasCycle(SinglyLinkdedList head){
        if(head == null) return false;

        SinglyLinkdedList slowPointer = head;
        SinglyLinkdedList fastPointer = head.next;

        while (fastPointer!=null && fastPointer.next != null){
            if(slowPointer == fastPointer) return true;

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return false;
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
