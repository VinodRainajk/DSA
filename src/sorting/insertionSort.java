package src.sorting;

import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[] unsortedarray = new int[] {1,4,1,9,2,3};
        System.out.println(Arrays.toString(insertionSort(unsortedarray)));
    }

    public static  int[] insertionSort(int[] unorderedArray){

        for(int idx = 0; idx < unorderedArray.length-1; idx++){

            for(int jdx = idx+1; jdx >= 1; jdx--){
                if(unorderedArray[jdx] < unorderedArray[jdx-1]){
                    int temp = unorderedArray[jdx-1];
                    unorderedArray[jdx-1] = unorderedArray[jdx];
                    unorderedArray[jdx] = temp;
                }else {
                    break;
                }

            }
        }
        return unorderedArray;

    }

}
