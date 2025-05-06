package src.trees;

public class PopulatingNextRightPointer {

    public Node connect(Node root) {

        Node levelNode = root;

        if(root == null){
            return root;
        }

        while(levelNode.left != null){
            Node currentNode = levelNode;

            while(currentNode!=null){
                currentNode.left.next =  currentNode.right;

                if(currentNode.next!= null ){
                    currentNode.right.next = currentNode.next.left;
                }
                currentNode = currentNode.next;
            }
            levelNode = levelNode.left;
        }

        return root;
    }


}
