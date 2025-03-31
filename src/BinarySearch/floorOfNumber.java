package src.BinarySearch;

public class floorOfNumber {

    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        System.out.println(findFloorOfNumber(arr,10));
    }


    public static int  findFloorOfNumber(int array[], int target)
    {
        int start = 0;
        int end = array.length-1;

        while(start<=end){
          int mid = start + (end-start)/2;

          if(target==array[mid]) return mid;

          if(target < array[mid]){
              end = mid -1;
          }else {
              start = mid+1;
          }


        }
        return end;
    }
}
