package src.recursion;

import java.util.ArrayList;

public class linerSearchArry {

    public static void main(String[] args) {
        int[] inputValues = {1,2,4,3,3,6,6,6,9,10};
        System.out.println(findElements(inputValues,0,6));

    }

    public static ArrayList<Integer> findElements(int[] input, int idx, int target){
        ArrayList<Integer> returnvl = new ArrayList<>();

        if(input.length == idx)
            return returnvl;

        if(input[idx] == target){
            returnvl.add(idx);
        }
         returnvl.addAll(findElements(input, ++idx,target));
        return returnvl;

    }

}
