package src.trees;

import java.util.LinkedList;
import java.util.Queue;

public class symmetricTree {

    public boolean isSymmetric(TreeNode root) {

        if(root== null || (root.left ==null && root.right == null) ){
            return true;
        }

        if(root.left.val != root.right.val){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            TreeNode leftnode =  queue.remove();
            TreeNode rightNode =  queue.remove();

         if(leftnode.left != null && rightNode.right != null )  {
             if(leftnode.left.val != rightNode.right.val){
                 return false;
             }
         } else{
             if((leftnode.left != null && rightNode.right == null ) || (leftnode.left == null && rightNode.right != null )) {
                 return false;
             }
         }

            if(leftnode.right != null && rightNode.left != null )  {
                if(leftnode.right.val != rightNode.left.val){
                    return false;
                }
            } else{
                if((leftnode.right != null && rightNode.left == null ) || (leftnode.right == null && rightNode.left != null )) {
                    return false;
                }
            }


            queue.offer(leftnode.left);
            queue.offer(rightNode.right);
            queue.offer(leftnode.right);
            queue.offer(rightNode.left);

        }

     return true;
    }
}
