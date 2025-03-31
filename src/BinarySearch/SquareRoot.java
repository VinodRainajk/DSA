package src.BinarySearch;

public class SquareRoot {

    public static void main(String[] args) {
        System.out.println( mySqrt(2147395599));
    }

    public static int mySqrt(int y) {
        Integer x = y;
        Long start = 0L;
        Long end = x.longValue();

        while(start <= end ){
            System.out.println("********* ");
            System.out.println("start "+start);
            System.out.println("end "+end);


            Long  mid = start + (end-start)/2;
            System.out.println("mid "+mid);
            if(mid*mid == x ) return mid.intValue();
            if(mid*mid > x) end = mid -1;
            else start = mid+1;

        }

        return end.intValue();

    }
}
