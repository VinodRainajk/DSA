package src.LinkedList;

public class PalinDromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        ListNode middle =  middleNode(head);
        System.out.println( "Middle Node "+ middle.val);
        ListNode reversthead = reverseLinkedList(middle.next);
        middle.next = reversthead;
        Boolean returnvale = comparisonOperation( head, reversthead,middle);
        middle.next = reverseLinkedList (middle.next);
        return returnvale;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow =  head;
        ListNode fast =  head.next;
        while( fast != null && fast.next!=null){
            slow= slow.next;
            fast =  fast.next.next;
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

    public boolean comparisonOperation(ListNode leftHead, ListNode rightHead,ListNode middle ){

        ListNode masterRight = rightHead;

        while( leftHead!= null && rightHead!= null ){

            if(leftHead.val != rightHead.val){
                return  false;
            }
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }

        if( rightHead == null && leftHead== masterRight)
        {
            return true;
        }

        if( rightHead == null && leftHead== middle) {
            return true;
        }

        return false;
    }

}
