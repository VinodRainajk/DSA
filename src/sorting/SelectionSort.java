package src.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] unsortedarray = new int[] {4,5,9,2,3};
        System.out.println(Arrays.toString(selectionSortAlgo(unsortedarray)));
    }

    public static  int[] selectionSortAlgo(int[] unorderedArray){


        for(int idx = 0; idx <unorderedArray.length; idx++ ){
            //find the max element in the array
            int maxElementIdx = 0;


            for(int jdx =0; jdx< unorderedArray.length-idx; jdx++ ){
                if(unorderedArray[maxElementIdx] < unorderedArray[jdx]) {
                    maxElementIdx = jdx;
                }
            }
            int temp = unorderedArray[unorderedArray.length-idx-1];
            unorderedArray[unorderedArray.length-idx-1] = unorderedArray[maxElementIdx];
            unorderedArray[maxElementIdx] = temp;
        }

    return unorderedArray;

    }


}
