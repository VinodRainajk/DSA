package src.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sumTraingleArray {

    public static void main(String[] args) {
        int [] input = {1,2,3,4,5};
        sumArr(input);
    }

    public static void sumArr(int[] input){

        if(input.length==1){
            //System.out.println(Arrays.toString(input));
            return ;
        }

        int [] output = new int [input.length-1];
        int jdx =0;
        for(int idx =1; idx< input.length; idx++)
        {
            output[jdx] = input[idx-1]+input[idx];
            jdx++;
        }
        sumArr(output);
        System.out.println(Arrays.toString(output));

    }
}
