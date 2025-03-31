package src.recursion;

import java.util.ArrayList;

public class PermutationProblem {

    public static void main(String[] args) {
        permutationProblem("","abc");
    }

    public static void permutationProblem(String input,String pendingValue){

        if(pendingValue.isEmpty()){
            System.out.println(input);
            return;
        }

        char valToBeAdded =  pendingValue.charAt(0);

        for(int idx =0; idx<=input.length();idx++){
            String first = input.substring(0,idx);
            String second =input.substring(idx,input.length());
            permutationProblem(first+valToBeAdded+second,pendingValue.substring(1));
        }



    }
}
