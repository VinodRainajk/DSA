package src.LinkedList;

public class MainLinkedList {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addNodFirst(4);
        ll.addNodFirst(2);
        ll.addNodFirst(1);
        ll.display();
        System.out.println("");
        LinkedList ll2 = new LinkedList();
        ll2.addNodFirst(5);
        ll2.addNodFirst(3);
        ll2.addNodFirst(0);
        ll2.display();
        System.out.println("");
        ll.mergeTwoLists(ll.head, ll2.head);
       
    }
}
