package src.recursion;

public class PhoneNumber {

    public static void main(String[] args) {
        phoneBookCombination("","12");
    }


    public static void phoneBookCombination(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        int digit = (int)unprocessed.charAt(0) - '0';

        for(int idx = (digit-1)*3 ; idx < digit*3; idx++){
            char processedval = (char)('a'+idx);
            phoneBookCombination(processed+String.valueOf(processedval), unprocessed.substring(1));
        }


    }

}
