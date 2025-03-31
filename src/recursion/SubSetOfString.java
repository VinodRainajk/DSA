package src.recursion;

import java.util.ArrayList;

public class SubSetOfString {

    public static void main(String[] args) {

        ArrayList<String> input = subSetProblem("","abc");
        System.out.println(input.toString());

    }

    public static ArrayList<String> subSetProblem(String returnval, String input){

        if(input.isEmpty() ){

            ArrayList<String> retval = new ArrayList<>();
            if (returnval.length()>0){
                retval.add(returnval);
            }

            return retval;
        }

        char val = input.charAt(0);
       ArrayList left =  subSetProblem(returnval+val,input.substring(1) );
       ArrayList right = subSetProblem(returnval,input.substring(1) );

       left.addAll(right);
       return left;

    }
}
