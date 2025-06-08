package src.BinarySearch;

import java.util.Arrays;

public class FindThePeakElement {

    public static void main(String[] args) {
        int[] nums = {3,1,2};
        System.out.println(findPeakElement(nums));
    }

    public static  int findPeakElement(int[] nums) {

        int start =0;
        int end = nums.length-1;
        int mid = 0;

        while(start <= end){
            mid =  start + (end-start)/2;

            if((mid-1) <0){
                if(nums[mid] > nums[mid+1]){
                    return mid;
                }else{
                    return mid+1;
                }
            }

            if((mid+1) >= nums.length){
                if(nums[mid] > nums[mid-1]){
                    return mid;
                }else{
                    return mid-1;
                }
            }

            if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]){
                return mid;
            }

            if(nums[mid-1] >  nums[mid]){
                end = mid-1;
            } else{
                if(nums[mid+1] >= nums[mid]){
                    start = mid+1;
                }
            }



        }
      return -1;

    }
}
