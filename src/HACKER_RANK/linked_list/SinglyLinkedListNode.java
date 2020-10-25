package HACKER_RANK.linked_list;

public class SinglyLinkedListNode {

    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SinglyLinkedListNode getNext() {
        return next;
    }

    public void setNext(SinglyLinkedListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SinglyLinkedListNode{");
        sb.append("data=").append(data);
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}
