package src.slidingWindow;

import java.util.HashMap;

public class LongestRepeatingCharacteReplacement {

    public static void main(String[] args) {
        characterReplacement("AABABBA",1);
    }

    public static int characterReplacement(String s, int k) {

    int maxFrequency = 0;
    int maxLength = 0;
    int l =0;
    int r = 0;
    HashMap<Character,Integer> container = new HashMap<>();
    while(r < s.length()){
        if(container.containsKey(s.charAt(r))){
            Integer value = container.get(s.charAt(r));
            container.put(s.charAt(r), value+1);
        }else {
            container.put(s.charAt(r),1);
        }
        maxFrequency = Math.max(maxFrequency,container.get(s.charAt(r)));
        if(((r-l+1)-maxFrequency) > k){
            Integer value = container.get(s.charAt(l));
            container.put(s.charAt(l), value-1);
            l++;
        }

        if(((r-l+1)-maxFrequency) <= k){
            maxLength = Math.max(maxLength, ((r-l+1)));
        }

        r++;
    }

       return maxLength;
    }
}
