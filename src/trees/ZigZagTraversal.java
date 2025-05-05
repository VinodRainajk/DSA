package src.trees;

import java.util.*;

public class ZigZagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> returnList = new ArrayList<>();
        if(root == null){
            return returnList;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean reverse = true;

        while(!deque.isEmpty()){

            List<Integer> currentList = new ArrayList<>();

                int currentSize =  deque.size();
                for(int idx = 0; idx< currentSize ; idx++) {
                    TreeNode currentNode = null;
                    if (reverse){
                        currentNode = deque.pollFirst();
                        currentList.add(currentNode.val);
                        if(currentNode.left !=null){
                            deque.addLast(currentNode.left);
                        }
                        if(currentNode.right !=null){
                            deque.addLast(currentNode.right);
                        }
                     }else{
                        currentNode = deque.pollLast();
                        currentList.add(currentNode.val);
                        if(currentNode.right !=null){
                            deque.addFirst(currentNode.right);
                        }
                        if(currentNode.left !=null){
                            deque.addFirst(currentNode.left);
                        }
                     }

                }


            reverse = !reverse;
            returnList.add(currentList);
        }
        return returnList;


    }
}
