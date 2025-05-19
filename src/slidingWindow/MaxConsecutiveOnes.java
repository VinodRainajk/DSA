package src.slidingWindow;

public class MaxConsecutiveOnes {

    public int longestOnes(int[] nums, int k) {
        int maxSize =0;
        int l=0;
        int r=0;
        int zeroCount = 0;

        while(r < nums.length){

            if(nums[r]==0){
                zeroCount++;
            }
            if(zeroCount <= k){
                maxSize =  Math.max(r-l+1,maxSize);
            }else{

                if(nums[l] == 0){
                    zeroCount --;
                }
                l++;
            }
            r++;
        }
        return maxSize;
    }
}
