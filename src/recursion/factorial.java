package src.recursion;

public class factorial {


    public static int fact(int value){

        if(value<1){
            return 1;
        }

        return value * fact(value-1);

    }

    public static void main(String[] args) {
        System.out.println(fact(5));
    }
}
