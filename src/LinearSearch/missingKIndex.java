package src.LinearSearch;

import java.util.Arrays;

public class missingKIndex {

    public static void main(String[] args) {
        int[] unsortedarray = {2};
        System.out.println(findKthPositive(unsortedarray,1));
    }

    public static int findKthPositive(int[] arr, int k) {
        int start =0;
        int end = arr.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;
            int missingIndex = arr[mid] - (mid +1);
            if(missingIndex > k){
               end= mid-1;
            }else{
              start = mid +1;
            }
        }

    return k+end+1;
    }
}
