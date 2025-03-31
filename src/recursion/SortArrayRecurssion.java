package src.recursion;

public class SortArrayRecurssion {

    public static boolean arrayIsSorted(int[] input , int idx, int jdx){

        if(input.length-1==idx){return true;}
        if(input[idx] > input[jdx]){return false;}

        idx++;
        jdx++;

        return arrayIsSorted(input,idx,jdx);

    }

    public static void main(String[] args) {

    int[] inputValues = {1};
        System.out.println(arrayIsSorted(inputValues, 0, 1));



    }
}
