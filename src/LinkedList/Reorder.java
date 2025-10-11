package src.LinkedList;

public class Reorder {


    public void reorderList(ListNode head) {

        ListNode middle = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            middle = middle.next;
            fast = fast.next.next;
        }

        ListNode tempHead = middle.next;
        middle.next = null;
        ListNode secondHead = tempHead;

        if (head == null || head == middle) {
            return;
        }

        while (tempHead.next != null && tempHead != null) {

            ListNode temp = tempHead.next;
            tempHead.next = tempHead.next.next;
            temp.next = secondHead;
            secondHead = temp;

        }

        ListNode firstHead = head;

        while (firstHead != null && secondHead != null) {


            ListNode second = secondHead;
            ListNode first = firstHead;

            secondHead = secondHead.next;
            firstHead = firstHead.next;

            second.next = first.next;
            first.next = second;


        }
    }

    }
