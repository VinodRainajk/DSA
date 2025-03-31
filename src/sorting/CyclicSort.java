package src.sorting;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] unsortedarray = new int[] {3,5,2,1,4};
        System.out.println(Arrays.toString(cyclicSortingAlgo(unsortedarray)));
    }

    public static int[] cyclicSortingAlgo(int[] inputArray){
        int idx = 0;
        while(idx < inputArray.length){

            if(inputArray[idx]-1==idx){
                idx++;
            }else{
                int temp = inputArray[idx];
                inputArray[idx] = inputArray[temp-1];
                inputArray[temp-1] = temp;
            }

        }

    return inputArray;
    }
}
