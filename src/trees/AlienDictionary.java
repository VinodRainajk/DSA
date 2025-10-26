package src.trees;

import java.util.*;

public class AlienDictionary {

    public String foreignDictionary(String[] words) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        Map<Character,Integer> indegree = new HashMap<>();

        for(int idx =0; idx< words.length; idx++){
           for(int jdx =0; jdx < words[idx].length(); jdx++){
               graph.putIfAbsent(words[idx].charAt(jdx),new ArrayList<>());
               indegree.putIfAbsent(words[idx].charAt(jdx),0);
           }
         }

        for(int idx =0; idx <words.length-1; idx++){
            String word1 = words[idx];
            String word2 = words[idx+1];
            int len = Math.min(word1.length(), word2.length());
            if (word1.length() > word2.length() &&
                    word1.substring(0, len).equals(word2.substring(0, len))) {
                return "";
            }
            int ptr =0;
            while(ptr < len){
                if(word1.charAt(ptr) != word2.charAt(ptr)){
                   if(!graph.get(word1.charAt(ptr)).contains(word2.charAt(ptr))){
                       graph.get(word1.charAt(ptr)).add(word2.charAt(ptr));
                       indegree.put( word2.charAt(ptr), indegree.get(word2.charAt(ptr))+1);
                   }
                    break;
                }
                ptr++;
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for(Character chr : indegree.keySet()){
            if(indegree.get(chr)==0){
                queue.add(chr);
            }
        }
        String returnval = "";
        while (!queue.isEmpty()){
            Character val = queue.remove();
            returnval = returnval.concat(String.valueOf(val));
            List<Character> listChar = graph.get(val);

            for(int idx =0; idx< listChar.size(); idx++){
               Integer indgreeval = indegree.get(listChar.get(idx));
               indgreeval = indgreeval -1;

               if(indgreeval==0){
                   queue.add(listChar.get(idx));
               }
                indegree.put(listChar.get(idx), indgreeval);
            }

        }

        if(returnval.length()!= indegree.size()){
            return  "";
        }

        return returnval;
    }


    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        alienDictionary.foreignDictionary(new String[]{"wrtkj","wrt"});

    }
}
