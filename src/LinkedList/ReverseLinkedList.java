package src.LinkedList;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode ActualHead = new ListNode();
        reverseListrecursive(head,ActualHead);
        return ActualHead.next;
    }

    public ListNode reverseListrecursive(ListNode head, ListNode ActualHead) {

        if(head == null || head.next == null){
            ActualHead.next = head;
            return head;
        }
        System.out.println(" before"+  head.val);
        ListNode returnValue =   reverseListrecursive(head.next,ActualHead);
        returnValue.next = head;
        head.next = null;
        return returnValue.next;

    }



}
