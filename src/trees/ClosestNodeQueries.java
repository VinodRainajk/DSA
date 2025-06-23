package src.trees;

import java.util.ArrayList;
import java.util.List;

public class ClosestNodeQueries {

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> returnvalues = new ArrayList<>();
        for(int idx =0; idx< queries.size() ; idx++){
            List<Integer> arr = new ArrayList<>();
            Integer minValue = findMinElement(root, Integer.MIN_VALUE,queries.get(idx));
            if(minValue == Integer.MIN_VALUE){
                minValue = -1;
            }
            arr.add(minValue);
            Integer maxValue = findMaxElement(root, Integer.MAX_VALUE,queries.get(idx));
            if(maxValue == Integer.MAX_VALUE){
                maxValue = -1;
            }
            arr.add(maxValue);
            returnvalues.add(arr);
        }

        return returnvalues;
    }

    public  Integer findMinElement(TreeNode root, Integer currentMinVal, Integer queryElement){

        if(root == null){


            return currentMinVal;
        }

        if(root.val == queryElement){
            return root.val;
        }

        if(root.val > currentMinVal && root.val < queryElement){
            currentMinVal = root.val;
            return findMinElement(root.right, currentMinVal , queryElement);
        }{
            return findMinElement(root.left, currentMinVal , queryElement);
        }

    }

    public  Integer findMaxElement(TreeNode root, Integer currentMaxVal, Integer queryElement){

        if(root == null){

            return currentMaxVal;
        }

        if(root.val == queryElement){
            return root.val;
        }

        if(root.val < currentMaxVal && root.val > queryElement){
            currentMaxVal = root.val;
            return findMaxElement(root.left, currentMaxVal , queryElement);
        }{
            return findMaxElement(root.right, currentMaxVal , queryElement);

        }

    }

}
