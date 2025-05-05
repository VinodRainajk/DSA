package src.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> returnList = new ArrayList<>();
        if(root == null){
            return returnList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int currentSize =  queue.size();
            Double summedValue = 0D;
            int counter = 0;
            for(int idx = 0; idx< currentSize ; idx++){
                counter++;
                TreeNode currentNode =  queue.remove();
                if(currentNode.left !=null){
                    queue.offer(currentNode.left);
                }

                if(currentNode.right !=null){
                    queue.offer(currentNode.right);
                }
                summedValue = summedValue +currentNode.val;
            }

            Double returnVal = (double) (summedValue/counter);
            returnList.add(returnVal);
        }
        return returnList;
    }
}
