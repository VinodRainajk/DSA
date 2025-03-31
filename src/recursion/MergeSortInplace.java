package src.recursion;

import java.util.Arrays;

public class MergeSortInplace {
    public static void main(String[] args) {
        int [] input = {1,7,2,9,45,12,17};
        mergeSort(input,0,input.length);
        System.out.println(Arrays.toString(input));
    }

    public static void mergeSort(int[] inputArray, int start, int end){
        if(end-start <=0){
            return ;
        }
        int mid =  start + (end-start)/2;
        mergeSort(inputArray,start,mid);
        mergeSort(inputArray,mid,end);
    }

}
