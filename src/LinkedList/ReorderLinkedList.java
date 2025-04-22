package src.LinkedList;

public class ReorderLinkedList {


    public void reorderList(ListNode head) {

        ListNode middle =  fincMiddle(head);
        ListNode reversthead = reverseLinkedList(middle.next);
        middle.next = reversthead;
        ListNode masterHead = head;
        ListNode headTemp = head;
        ListNode reverstheadTemp = reversthead;
        middle.next = null;
        while(reverstheadTemp!=null){
            headTemp = headTemp.next;
            reverstheadTemp = reverstheadTemp.next;
            head.next = reversthead;
            reversthead.next = headTemp;
            head = headTemp;
            reversthead= reverstheadTemp;
        }


    }

    public ListNode fincMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseLinkedList(ListNode head){

        if(head == null || head.next== null){
            return head;
        }

        ListNode prevNode = null;
        ListNode presentNode = head;
        ListNode nextNode = head.next;

        while(nextNode!= null){
            presentNode.next = prevNode;
            prevNode = presentNode;
            presentNode = nextNode;
            nextNode = nextNode.next;
        }

        presentNode.next = prevNode;
        return presentNode;


    }



}
