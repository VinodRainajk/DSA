package src.slidingWindow;

import java.util.HashMap;

public class NumberOfSubString {

    public static void main(String[] args) {
        numberOfSubstrings("abcabc");
    }

    public static  int numberOfSubstrings(String s) {
        HashMap<Character,Integer> container=  new HashMap<>();
        container.put(s.charAt(0),1);
        int retVal2 = numberOfSubstringsHelper(String.valueOf(s.charAt(0)),s.substring(1),container);
        int retVal = numberOfSubstringsHelper("",s.substring(1),null);

        return retVal+retVal2;
    }

    public static int numberOfSubstringsHelper(String processed, String unprocessed, HashMap container){

        if(container == null){
            container = new HashMap();
        }

        if(container.size()==3){
            return 1 + unprocessed.length();
        }

        if(unprocessed.isEmpty()){
            return 0;
        }

        Character currCharacter = unprocessed.charAt(0);
        if(container.containsKey(currCharacter)){
            Integer value = (Integer) container.get(currCharacter);
            value = value+1;
            container.put(currCharacter,value);
        }else{
            container.put(currCharacter,1);
        }

        String pendingString = unprocessed.substring(1);
        int val1 = 0 ;
        int val2 = 0 ;

        val2=  numberOfSubstringsHelper(processed.concat(String.valueOf(currCharacter)),pendingString,container);

        if(processed.isEmpty()){
            val1 = numberOfSubstringsHelper("",pendingString,null);
        }

        return val1+val2;
    }
}
