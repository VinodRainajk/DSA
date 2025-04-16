package src.LinkedList;

public class FastAndSlowLinkedList {
    public boolean hasCycle(LinkedListtemplate head) {
        LinkedListtemplate slow = head;
        LinkedListtemplate fast = head;

        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow ==fast){
                return true;
            }

        }


        return false;
    }
}
