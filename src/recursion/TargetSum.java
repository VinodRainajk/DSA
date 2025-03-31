package src.recursion;

public class TargetSum {

    public static void main(String[] args) {
        int [] nums  = {1};
        int target = 1;
        System.out.println(findTargetSumWays(nums,target));
    }

    public static int findTargetSumWays(int[] nums, int target){
        return taregtSumWays(0, 0, nums, target);
    }

    public static int taregtSumWays(int currentIndx, int currentSum, int[] nums, int target){


        if(currentIndx==nums.length){
           if(currentSum==target){
                return 1;
            }
            return 0;
        }

       int newIdx =  currentIndx+1;
       int addValues = 0;
       addValues = addValues+ taregtSumWays(newIdx, currentSum +nums[currentIndx],nums,target);
       int subValues = 0;
        subValues=subValues+ taregtSumWays(newIdx, currentSum -nums[currentIndx],nums,target);

       return addValues+subValues;

    }

}
