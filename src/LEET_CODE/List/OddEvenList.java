package LEET_CODE.List;


public class OddEvenList {

    public static void main(String[] args) {

    }

    //print odd indexes of list first and then even, so nodes at 1.3.5 and then 2.4.6
    static ListNode OddEvenList(ListNode head){
        if( head == null) return null;

        ListNode odd = head;//1 index -> we create list of odd nodes
        ListNode even = head.next;//2 index -> to create list of even nodes

        ListNode evenHead = even;//head of our future list of even nodes

        while (even != null && even.next != null){//while smth to move on
            odd.next = even.next;//steps in 2, so 1 - 3 - 5
            odd = odd.next;//move in odd position
            even.next = odd.next;//steps in 2 so 2 - 4 - 6
            even = even.next;//move in even position
        }

        odd.next = evenHead;//concatenate last odd with first even - to create new list
        return head;//head was same 
    }



    static class ListNode {
        int data;
        ListNode next;
        public ListNode(int data) { this.data = data;}
    }
}
