package src.LinkedList;

public class MergerList {

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
        }

        if(list1 == null){
            returnList.next = returnList.next;
            returnList.next = list2;

        } else if(list2 == null){
            returnList.next = returnList.next;
            returnList.next = list1;

        }

        return head;
    }
}
