package src.LinkedList;

public class MainLinkedList {

    public static void main(String[] args) {

        ListNode ll = new ListNode();
        ll.addNodFirst(3);
        ll.addNodFirst(2);
        ll.addNodFirst(1);
        ll.addNodFirst(1);
        ll.addNodFirst(2);
        ll.addNodFirst(3);

        PalinDromeLinkedList llm = new PalinDromeLinkedList();
        llm.isPalindrome(ll.head);
    }
}
