package src.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetForArray {

    public static void main(String[] args) {
        int[] num = {1,2,3};
        subSetArray(num).forEach(System.out::println);


    }

    public static List<List<Integer>> subSetArray(int[] nums){

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for(Integer input : nums){
            int size = outer.size();;
            for(int idx =0; idx < size; idx++){
                List <Integer> innerList = new ArrayList<>(outer.get(idx));
                innerList.add(input);
                outer.add(innerList);
            }


        }
        return outer;
    }
}
