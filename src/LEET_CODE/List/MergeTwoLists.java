package LEET_CODE.List;

import HACKER_RANK.linked_list.SinglyLinkedListNode;

//merge two lists - should end up one sorted list
public class MergeTwoLists {

    static SinglyLinkedListNode mergeTwoLists(SinglyLinkedListNode list1, SinglyLinkedListNode list2){

        SinglyLinkedListNode temp_node = new SinglyLinkedListNode(0);//just a placeholder for our future list
        SinglyLinkedListNode current_node = temp_node;

        while (list1 != null && list2 != null){
            if(list1.getData() < list2.getData()){
                current_node.setNext(list1);// here strted our actual new list
                list1 = list1.getNext();//shift to move right in list1
            } else {
                current_node.setNext(list2);// here strted our actual new list
                list2 = list2.getNext();//shift to move right in list2
            }
            current_node = current_node.getNext();//shift right with our new list
        }

        if ( list1 !=null){//if smth still left in list1 , when list2 was over already
            current_node.setNext(list1);//so all remainder of list1 will be just appended to the end of new list
            list1 = list1.getNext();//unnecessary
        }
        if(list2 != null){//f smth still left in list2 , when list1 was over already
            current_node.setNext(list2);
            list2 = list2.getNext();
        }

        return temp_node.getNext();//next cause temp node head was just a placeholder - actual list starts from it's next 
    }
}
