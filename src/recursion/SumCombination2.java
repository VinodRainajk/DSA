package src.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;

public class SumCombination2 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> returnval = new ArrayList<>();
        sumRecursive(0, candidates, target, new ArrayList<>() , 0,returnval);
        return returnval;

    }


    public static void sumRecursive(int currIdx , int[] candidates, int target, List<Integer> currentElements, int currentSum , List<List<Integer>> returnval) {


        if(target == currentSum){
            returnval.add(new ArrayList<>(currentElements));
            return;
        }

        for(int idx = currIdx; idx < candidates.length ; idx++){
               if(idx > currIdx && candidates[idx] == candidates[idx-1]) continue;


                if(currentSum + candidates[idx] > target){
                    break;
                } else{
                    currentElements.add(candidates[idx]);
                    sumRecursive (idx+1 , candidates , target , currentElements,currentSum+ candidates[idx],returnval);
                    currentElements.remove(currentElements.size()-1);
                }
           }
    }

    public static void main(String[] args) {
        
        int[] arr = {10, 1, 2, 7, 6, 1};
        System.out.println(combinationSum2(arr,8));
    }





}
