package src.BinarySearch;

public class MinimumInRotated {
    public int findMin(int[] nums) {
        int peak = binarySearch(nums);

        return nums[peak];
    }

    public int binarySearch(int[] nums){
        int first =0;
        int last = nums.length -1;
        int min = nums[first];

        while(first<=last){
            int mid = last + (first-last)/2;
            // find which part is sorted and get minimum

            if(nums[first] < nums[mid]){
               min = Math.min(nums[first],min);
               first = mid+1;
            }else{
                min = Math.min(nums[mid],min);
                last = mid-1;
            }

        }
    return min;
    }
    public static void main(String[] args) {
        MinimumInRotated minimumInRotated = new MinimumInRotated();
        int[] arr = new int[]{3,4,5,6,1,2};
        minimumInRotated.binarySearch(arr);
    }
}
