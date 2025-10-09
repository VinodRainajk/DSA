package src.slidingWindow;

public class TwoIntegerSum {
    public int[] twoSum(int[] numbers, int target) {

        int l = 0;
        int r = numbers.length-1;

        while(r>l){
            System.out.println("numbers[r] "+numbers[r]);
            System.out.println("numbers[l] "+numbers[l]);
            if(numbers[r]+numbers[l]==target){
                return new int[]{l,r};
            }

            if(numbers[r]+numbers[l] > target){
                 r--;
            }else
            {
                l++;
            }

        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        TwoIntegerSum twoIntegerSum = new TwoIntegerSum();
        int[] list = new int[]{1,2,3,4};
        System.out.println(twoIntegerSum.twoSum(list,3));
    }
}
