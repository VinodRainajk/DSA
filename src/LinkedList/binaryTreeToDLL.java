package src.LinkedList;

public class binaryTreeToDLL {
    static class Node {
        int data;
        Node left, right;

        Node() {
            this.data = 0;
            this.left = this.right = null;
        }

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }


    public static Node bToDLL(Node root) {
        if(root== null){
            return null;
        }

        Node head = new Node();
        inorder(root, head);
        return head.right;
    }

    public static Node inorder(Node root, Node dlist){
        if(root == null ){
            return dlist;
        }

        dlist =  inorder(root.left,dlist);
            System.out.println("dlist.data "+dlist.data);
            System.out.println("root.data "+root.data);

            Node element = new Node();
            element.data = root.data;
            dlist.right = element;
            element.left = dlist;
        dlist = dlist.right;
        return inorder(root.right,dlist);
    }

    public static void main(String[] args) {
            // Create root node with value 1
            Node root = new Node(1);

            // Assign left and right children
            root.left = new Node(3);
            root.right = new Node(2);

            // Print the tree structure
            System.out.println("Root: " + root.data);
            System.out.println("Left Child: " + root.left.data);
            System.out.println("Right Child: " + root.right.data);

            Node nd = bToDLL(root);
        System.out.println(nd);
        }


}
