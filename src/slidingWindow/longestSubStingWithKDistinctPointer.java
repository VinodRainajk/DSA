package src.slidingWindow;

import java.util.HashMap;

public class longestSubStingWithKDistinctPointer {

    public   int numberOfSubstrings(String s) {
        HashMap<Character,Integer> container=  new HashMap<>();
        int count =0;

        container.put('a',-1);
        container.put('b',-1);
        container.put('c',-1);

        for (int idx =0; idx < s.length() ; idx++){
            if(s.charAt(idx)=='a'){
                container.put('a',idx);
            }

            if(s.charAt(idx)=='b'){
                container.put('b',idx);
            }

            if(s.charAt(idx)=='c'){
                container.put('c',idx);
            }

            count = count + (Math.min(Math.min(container.get('a'), container.get('b')),container.get('c'))+1);
        }

        return count;
    }
}
