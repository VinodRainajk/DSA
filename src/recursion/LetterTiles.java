package src.recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LetterTiles {
    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAABBC"));
    }

    public static int numTilePossibilities(String tiles) {
        Set<String> returnVal = new HashSet<>();
        calcultion("",tiles,returnVal);
        return returnVal.size();

    }

    public static void calcultion(String processed, String unprocessed, Set<String> returnValue)
    {
        if(unprocessed.isEmpty()){
            return ;
        }

        for(int idx =0; idx < unprocessed.length(); idx++){
            String currentelement = String.valueOf(unprocessed.charAt(idx));
            String firstpart= unprocessed.substring(0,idx);
            String secondPart =  unprocessed.substring(idx+1);
            String addValue = processed.concat(currentelement);
            returnValue.add(addValue);
            calcultion(addValue,firstpart.concat(secondPart), returnValue);
        }



    }

}
