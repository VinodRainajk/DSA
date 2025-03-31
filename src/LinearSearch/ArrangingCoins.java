package src.LinearSearch;

public class ArrangingCoins {

    public static void main(String[] args) {
        arrangeCoins(1804289383);

    }
    public static int arrangeCoins(int n) {

        Long start = 0L;
        Integer end1 = n;
        Long end =  Long.valueOf(end1);

        while(start<=end){

            Long mid = (start + (end-start)/2);

            Long currval =  Long.valueOf((((1+mid)*mid)/2));

            if(currval >n ){
                end = mid -1;
            }else{
                start = mid+1;
            }


        }
        return (int)(start-1);


    }
}
