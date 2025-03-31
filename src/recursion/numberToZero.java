package src.recursion;

public class numberToZero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(8));
    }
    public static int numberOfSteps(int num) {
        if(num==0){
            return 0;
        }
        int count = 1;
        if(num%2==0){
            return count+ numberOfSteps(num/2);
        }else{
            return count+ numberOfSteps(num-1);
        }
    }
}
