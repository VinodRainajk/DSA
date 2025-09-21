package src.slidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubStringConcat {
    public List<Integer> findSubstring(String s, String[] words) {

       if(s.length() < words.length){
           return new ArrayList<>();
       }


        Set<String> permutation = new HashSet<>();
        List<Integer> returnValue = new ArrayList<>();
        List<String> inputVal = new ArrayList<>();
        List<String> processed = new ArrayList<>();
        for(int idx =0; idx < words.length; idx++){
            inputVal.add(words[idx]);
            if(!s.contains(words[idx])){
                return new ArrayList<>();
            }
        }

        getPermutationVal("",inputVal,permutation);

         for(String currWord : permutation) {
            String input = s;
            int fromidx = 0;
            while(input.indexOf(currWord,fromidx)!=-1){
                int index = input.indexOf(currWord,fromidx);
                returnValue.add(index);
                fromidx = index+1;

            }

        }

        return returnValue;
    }

    public void getPermutationVal(String processed, List<String> unprocessed,Set<String>processedList){
        if(unprocessed.size() ==0){
            processedList.add(processed);
            return;
        }

        for(int idx=0; idx < unprocessed.size() ; idx ++){
            List<String> unprocessedtemp = new ArrayList<>(unprocessed);
            String processedtemp = processed.concat(unprocessedtemp.get(idx));
            unprocessedtemp.remove(idx);
            getPermutationVal(processedtemp , unprocessedtemp,processedList);
        }
    }

    public static void main(String[] args) {
        SubStringConcat ssc = new SubStringConcat();
        System.out.println(ssc.findSubstring("fffffffffffffffffffffffffffffffff", new String[]{"a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"}));
    }

}
