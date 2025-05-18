package src.slidingWindow;

public class MaxPointFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum =0 ;

        int maxSum = 0;

        for(int idx = 0; idx < k; idx++){

            leftSum = leftSum + cardPoints[idx];

        }
        maxSum = leftSum;

        if(k == cardPoints.length){
            return maxSum;
        }
        int jdx = k;
        int bdx = cardPoints.length-1;
        int rightSum = leftSum;
        while(jdx-1 >=0){

            jdx--;
            rightSum = (rightSum - cardPoints[jdx]) + cardPoints[bdx];
            maxSum = Math.max(rightSum,maxSum);
            bdx--;
        }

        return maxSum;
    }


}
