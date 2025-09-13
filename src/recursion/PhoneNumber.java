package src.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneNumber {




    public List<String> letterCombinations(String digits) {
        List<List<String>> phone = new ArrayList<>();
        List<String> output = new ArrayList<>();
        phone.add( Arrays.asList(" "));
        phone.add( new ArrayList<>());
        phone.add(Arrays.asList("a", "b", "c"));
        phone.add(Arrays.asList("d", "e", "f")); // index 2
        phone.add(Arrays.asList("g", "h", "i")); // index 3
        phone.add(Arrays.asList("j", "k", "l")); // index 4
        phone.add(Arrays.asList("m", "n", "o")); // index 5
        phone.add(Arrays.asList("p", "q", "r", "s")); // index 6
        phone.add(Arrays.asList("t", "u", "v")); // index 7
        phone.add(Arrays.asList("w", "x", "y", "z")); // index 8

        backtracking(digits,0, output, "" , phone );
        return output;
    }

    public void backtracking(String digits,int idx, List<String> output, String Input, List<List<String>> phone ){
        if(idx == digits.length()){
            if(!Input.isEmpty()){
                output.add(Input);
            }

            return ;
        }
        Integer currIdx = digits.charAt(idx)-'0';
        List<String> currVal = phone.get(currIdx);
        for(int jdx = 0; jdx <currVal.size(); jdx++ ){
            backtracking(digits,idx+1, output, Input.concat(currVal.get(jdx)) , phone );
        }
    }

}
