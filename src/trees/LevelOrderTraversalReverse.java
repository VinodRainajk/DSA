package src.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalReverse {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> returnList = new ArrayList<>();
        if(root == null){
            return returnList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int currentSize =  queue.size();
            List<Integer> currentList = new ArrayList<>();
            for(int idx = 0; idx< currentSize ; idx++){
                TreeNode currentNode =  queue.remove();
                if(currentNode.left !=null){
                    queue.offer(currentNode.left);
                }

                if(currentNode.right !=null){
                    queue.offer(currentNode.right);
                }
                currentList.add(currentNode.val);
            }
            returnList.add(0,currentList);
        }
        return returnList;
    }
}
