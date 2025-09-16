package src.slidingWindow;

public class MinSizeSubArray {
    public int minSubArrayLen(int target, int[] nums) {

        int minSubArray = (int)1e9;
        int idx =0;
        int jdx = 0;
        int currSum = 0;
        while(jdx < nums.length){
            currSum =  currSum + nums[jdx];
            if(currSum >= target){
                minSubArray = Math.min(minSubArray, (jdx-idx +1));

                while(currSum >= target && idx <= jdx)
                {
                    currSum =  currSum - nums[idx];
                    idx++;
                    if(currSum >= target){
                        minSubArray = Math.min(minSubArray, (jdx-idx +1));
                    }
                }
            }
            jdx++;
        }
        if(minSubArray == (int)1e9){
            return 0;
        }
        return minSubArray;
    }
}
