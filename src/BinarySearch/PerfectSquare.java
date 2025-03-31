package src.BinarySearch;

public class PerfectSquare {

    public static void main(String[] args) {
        System.out.println("isPerfectSquare "+isPerfectSquare(2147483647));
    }

    public static boolean isPerfectSquare(int num){
        Integer target = num;
        Long start = 0L;
        Long end = target.longValue();
        while(start<=end){
            Long mid = start + (end -start)/2;
            System.out.println("mid " + mid*mid);
            if(mid*mid == target){
                return true;
            }

            if(mid*mid< target){
                start = mid +1;
            }else{
                end = mid-1;
            }

        }

        return false;
    }
}
