package src.recursion;

public class Nto1 {


    public static void printValue(int n)
    {
        if(n == 0){
            return;
        }
        printValue(n-1);
        System.out.println("Value is " + n);
    }

    public static void main(String[] args) {
        printValue(5);
    }
}
