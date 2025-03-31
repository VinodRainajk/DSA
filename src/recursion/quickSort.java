package src.recursion;

import java.util.Arrays;

public class quickSort {


    public static void main(String[] args) {
        int [] input  = {1,7,2,9,45,12,17};
        qickSort(input,0,input.length-1);
        System.out.println(Arrays.toString(input));
    }

    private static void qickSort(int[] input, int low, int high) {

        if(low>=high){
            return;
        }

        int start =  low;
        int end = high;
        int mid = start + (end - start)/2;
        int pivot = input[mid];

        while(start <= end){

            while(input[start]<pivot){
                start++;
            }

            while(input[end]>pivot){
                end--;
            }

            if(start <= end){
                int temp = input[start];
                input[start] =  input[end];
                input[end]= temp;
                start++;
                end--;
            }

        }

        qickSort(input,low,end);
        qickSort(input,start,high);



    }


}
