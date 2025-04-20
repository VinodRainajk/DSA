package src.LinkedList;

public class LinkedListMergeSort {

    public ListNode sortList(ListNode head) {

        if(head==null || head.next == null){
            return head;
        }

        ListNode middle = middleNode(head);
        ListNode right = middle.next;
        middle.next = null;

        ListNode leftNode =  sortList(head);
        ListNode rightNode = sortList(right);
        return mergeTwoLists(leftNode,rightNode);
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode returnList = new ListNode();
        ListNode head =  returnList;

        while(list1 != null && list2 != null){

                ListNode temp = new ListNode();
                    if(list1.val <= list2.val){
                        temp = list1;
                        list1 = list1.next;
                    }else{
                        temp = list2;
                        list2 = list2.next;
                    }
                temp.next = null;
                returnList.next = temp;
                returnList= returnList.next;
        }

        if(list1 == null){
            returnList.next = list2;

        } else if(list2 == null){
            returnList.next = list1;

        }

        return head.next;
    }
}
