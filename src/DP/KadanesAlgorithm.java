package src.DP;

public class KadanesAlgorithm {
    int maxSubarraySum(int[] arr) {
        // Code here
        int max_sum = (int)-1e9;
        int curr_sum = (int)-1e9;

        for (int idx =0; idx < arr.length; idx++){

            curr_sum = curr_sum+ arr[idx];
            if(curr_sum < arr[idx]){
                curr_sum = arr[idx];
            }
            if(curr_sum> max_sum){
                max_sum = curr_sum;
            }




        }

        return max_sum;

    }
}
