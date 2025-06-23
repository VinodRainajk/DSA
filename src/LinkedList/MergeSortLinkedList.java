package src.LinkedList;

public class  MergeSortLinkedList {

    public ListNode sortList(ListNode head) {
        if(head== null || head.next== null){
            return head;
        }
        ListNode middleNode  =  findMiddel(head);
        ListNode temp = middleNode.next;
        middleNode.next = null;
        ListNode left =  sortList(head);
        ListNode right = sortList(temp);
        return mergeList(left,right);
    }

    public ListNode findMiddel(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null || fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public ListNode mergeList (ListNode leftSide, ListNode rightSide){
        ListNode head =  null;
        ListNode next = head;
        while(leftSide!=null || rightSide != null){
            ListNode temp = null;
            if(leftSide!=null && rightSide!=null){
                if(leftSide.val < rightSide.val){
                    temp = leftSide;
                    leftSide = leftSide.next;
                } else {
                    temp = rightSide;
                    rightSide = rightSide.next;
                }
                next.next = temp;
            } else {
                if(leftSide==null){
                    next.next = rightSide;
                    break;
                }else{
                    next.next = leftSide;
                    break;
                }

            }
            next = next.next;
        }
       return head.next;
    }



}
