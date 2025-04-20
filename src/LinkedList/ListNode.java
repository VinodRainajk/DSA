package src.LinkedList;

 public class ListNode {

      ListNode head ;
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next;

      }

     public void addNodFirst(int value){
         ListNode ll = new ListNode (value);
         ll.next = null;

         if(head == null){
             head= ll;
             return;
         }

         ll.next = head;
         head = ll;

     }
 }
