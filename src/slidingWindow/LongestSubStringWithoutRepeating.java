package src.slidingWindow;

import java.util.HashMap;

public class LongestSubStringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        int maxlength = 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> store = new HashMap<>();
        while (right < s.length()) {

            if (store.containsKey(s.charAt(right))) {
                {
                    int index = store.get(s.charAt(right));
                    for (int idx = left; idx <= index; idx++) {
                        store.remove(s.charAt(idx));
                        left++;
                    }

                }
            }
            maxlength = Math.max( maxlength, right - left +1);
            store.put(s.charAt(right), right);
            right++;
        }
        return maxlength;
    }
}
