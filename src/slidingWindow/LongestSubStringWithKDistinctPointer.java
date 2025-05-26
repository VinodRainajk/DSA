package src.slidingWindow;

import java.util.HashMap;

public class LongestSubStringWithKDistinctPointer {

    public int longestSubstring(String s, int k) {
        int maxStringSize= 0 ;
        int ldx = 0;
        int jdx= 0;

        HashMap<Character,Integer> container = new HashMap<>();
        while(jdx < s.length()){
        Character curr = s.charAt(jdx);
            if(container.containsKey(curr)){
             Integer val = container.get(curr);
             val = val+1;
             container.put(curr,val);
            }else{
                container.put(curr,1);
            }

           if(container.size()>k){
               Character chaValue =  s.charAt(ldx);
               Integer val = container.get(chaValue);
               val = val -1;
               if(val==0){
                   container.remove(chaValue);
               }else{
                  container.put(chaValue,val);
               }
           }

           if(container.size() <= k){
               maxStringSize = Math.max(maxStringSize, (jdx -ldx) +1);
           }

        }
        return maxStringSize;
    }

}
