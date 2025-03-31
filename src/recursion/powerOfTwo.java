package src.recursion;

public class powerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
    }
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n == 1 || (n%2 == 0 && isPowerOfTwo(n/2)));
    }

}
