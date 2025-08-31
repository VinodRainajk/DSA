package src.graph;

import java.util.*;

public class WordLadder2 {

    public static ArrayList<ArrayList<String>> findSequences(String startWord,
                                                             String targetWord,
                                                             String[] wordList) {

        Queue<ArrayList<String>> store = new LinkedList<>();
        ArrayList<String> first = new ArrayList<>();
        ArrayList<ArrayList<String>> returnList =  new ArrayList<>();
        first.add(startWord);
        store.add(first);
        HashSet<String> st = new HashSet<>();

        for (int idx =0; idx < wordList.length; idx++){
            if(wordList[idx] !=startWord ){
                st.add(wordList[idx]);
            }
        }
        int level =0;
        List<String> usedArray = new ArrayList<>();
        while(!store.isEmpty()){
            ArrayList<String> curr = store.remove();
            String currentWord =  curr.get(curr.size()-1);
             if(curr.size() > level){
                 level++;
                 for(int idx =0; idx < usedArray.size() ; idx++ ){
                     st.remove(usedArray.get(idx));
                 }
             }

             if(currentWord.equals(targetWord)){
                 if(returnList.size() ==0){
                     returnList.add(curr);
                 } else if (returnList.get(0).size() == curr.size()){
                     returnList.add(curr);
                 }
             }

            for(int idx =0 ; idx < currentWord.length(); idx++ ){
                for(char c = 'a'; c <='z'; c++){
                    char[] charset = currentWord.toCharArray();
                    charset[idx] = c;
                    String val = new String(charset);
                    if(st.contains(val)){
                        usedArray.add(val);
                        ArrayList<String> temp = new ArrayList<>(curr);
                        temp.add(val);
                        store.add(temp);
                    }

                }
            }

        }

        return returnList;
    }

    public static void main(String[] args) {
       String startWord  = "der";
       String targetWord = "dfs";
       String[] wordList  = new String[]{"des","der","dfr","dgt","dfs"};
        System.out.println(findSequences(startWord,
                     targetWord,
                wordList));
    }



}
