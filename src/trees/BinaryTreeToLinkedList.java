package src.trees;

public class BinaryTreeToLinkedList {
    public void flatten(TreeNode root) {

        TreeNode currentNode = root;

        while(currentNode != null){

            if(currentNode.left != null){
                TreeNode temp = currentNode.left;
                while(temp.right != null){
                    temp = temp.right;
                }
                temp.right =  currentNode.right;
                currentNode.right =  currentNode.left;
                currentNode.left = null;
            }


            currentNode = currentNode.right;
        }


    }
}
