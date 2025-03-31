package src.recursion;

public class ReverseANumber {

    public static void main(String[] args) {
  //    System.out.println(numberReverasl(182,0));
        System.out.println((int)Math.log10(123));

    }

    public static int numberReverasl(int value,int input){

        if(value%10==0){
            return input;
        }
        int val  = input*10 +value%10 ;
        return   numberReverasl(value/10,val) ;
    }
}
