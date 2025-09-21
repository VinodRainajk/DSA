package src.LinkedList;

public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode currNode = head;

        while(currNode!=null){
            currNode = currNode.next;
            size++;
        }
        if (size== 0 || k ==0)
            return  head;

        int rotation = k%size;
        if (rotation== 0)
            return  head;

        int counter = 1;
        currNode = head;
        ListNode newhead = head;
        ListNode newTail = head;

        while(currNode.next != null){
            if(counter == (size-rotation) ){
                newTail = currNode;
                newhead = currNode.next;
            }
            currNode = currNode.next;
            counter++;
        }
        currNode.next = head;
        newTail.next = null;
        return newhead;
    }
}
