package src.recursion;

public class SumDigit {

    public static int SumOfDigit(int input){

        if(input/10==0){
            return input;
        }

        return input%10 + SumOfDigit(input/10);
    }


    public static void main(String[] args) {

       // System.out.println(134%10);
       System.out.println(SumOfDigit(1342));
    }
}
