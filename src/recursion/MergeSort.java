package src.recursion;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int [] input = {1,7,2,9,45,12,17};
        System.out.println(Arrays.toString(mergeSort(input)));
    }

    public static int[] mergeSort(int[] input){

        if(input.length<2){
            return input;
        }
        int mid = input.length/2;
        int[] leftArray = mergeSort(Arrays.copyOfRange(input,0,mid));
        int[] rightArray =  mergeSort(Arrays.copyOfRange(input,mid,input.length));
        
        return merge(leftArray,rightArray);

    }

    private static int[] merge(int[] leftArray, int[] rightArray) {
        int leftIndx= 0;
        int rightIndx = 0;
        int[] returnArray = new int[leftArray.length+ rightArray.length];
        int returnIndx =0;

        while(leftIndx < leftArray.length && rightIndx < rightArray.length){
            if(leftArray[leftIndx] < rightArray[rightIndx]){
                returnArray[returnIndx] =   leftArray[leftIndx];
                leftIndx++;
            }else{
                returnArray[returnIndx] =   rightArray[rightIndx];
                rightIndx++;
            }
            returnIndx++;
        }

        while(leftIndx < leftArray.length){
                returnArray[returnIndx] =   leftArray[leftIndx];
                leftIndx++;
               returnIndx++;
        }

        while(rightIndx < rightArray.length){
            returnArray[returnIndx] =   rightArray[rightIndx];
            rightIndx++;
            returnIndx++;
        }

     return returnArray;
    }
}
