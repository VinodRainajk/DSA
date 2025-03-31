package src.BinarySearch;

public class BinarySearchBasic  {

    public static void main(String[] args) {
     int[] inputarray = {1,5,7,9,10,19,50,99,101};
     int target = 11;
     int ret= binarysearch(inputarray,target);
        System.out.println("Returned  status "+ ret);

    }


    public static int binarysearch(int[] inputarray, int traget)
    {
        int start = 0;
        int end = inputarray.length-1;

        while(start<=end)
        {

            int mid = start + (end-start)/2;

            if(inputarray[mid]==traget) return mid;
            else{
                 if(traget>inputarray[mid] )
                     start = mid+1;
                 else
                     end = mid -1;

            }


        }



        return -1;
    }


}
