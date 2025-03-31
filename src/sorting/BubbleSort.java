package src.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
       System.out.println(Arrays.toString(bubbleSort(new int[]{})));


    }

    public static int[] bubbleSort(int[] inputArray){

        int counter = 0; //
        int idx=1;


        if(inputArray.length<=1) return inputArray;

        while(counter <= inputArray.length -1){

            if(inputArray[idx] < inputArray[idx-1])
            {
                int temp = inputArray[idx];
                inputArray[idx] = inputArray[idx-1];
                inputArray[idx-1] =temp;

            }
            idx++;

            if(idx==inputArray.length) {
                idx=1;
                counter++;
            }
        }
        return inputArray;
    }

}
