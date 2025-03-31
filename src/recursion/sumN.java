package src.recursion;

public class sumN {

    public static int sumNnumber(int input){
        if(input==0){
            return 0;
        }

        return input+ sumNnumber(input-1);

    }

    public static void main(String[] args) {
        System.out.println(sumNnumber(3));

    }
}
