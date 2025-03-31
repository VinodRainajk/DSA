package src.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int [] input  = {2,3,5};
        System.out.println(combinationSum(input,8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> returnval= new ArrayList<>();
        combinationSUmSol(new ArrayList<>(),candidates,0,target,0,returnval);
        return returnval;
    }

    public static void combinationSUmSol(List<Integer> processed, int[] input, int idx,int target, int currentSum, List<List<Integer>> returnVal  ){

        if(currentSum==target){            returnVal.add(processed);
        return;
        }

        if(idx==input.length){            return;        }

        for(int jdx = idx ; jdx < input.length; jdx++){
            int tempSum = currentSum + input[jdx];
            List<Integer> tempProcessed =  new ArrayList<>(processed);
            if(tempSum<= target){
                tempProcessed.add(input[jdx]);
                combinationSUmSol(tempProcessed,input,jdx,target,tempSum,returnVal);
            }
        }


    }
}
