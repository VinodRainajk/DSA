package src.LinkedList;

public class MainLinkedList {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addNodFirst(10);
        ll.addNodFirst(20);
        ll.addNodFirst(30);
        ll.display();
        System.out.println("");
        ll.head = ll.recursiveAdditon2(1, 99 ,ll.head);
        ll.display();
    }
}
