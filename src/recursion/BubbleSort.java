package src.recursion;

import javax.crypto.spec.PSource;

public class BubbleSort {

    public static void main(String[] args) {
        int [] input = {1,7,2,9,45,12,17};

        int []  ret = sort(input,0,1);

        for(int k=0 ;  k<ret.length ; k++){
            System.out.println(ret[k]);
        }

    }

    public static int[] sort(int[] input, int idx,  int jdx){

        if(idx == input.length-1){
            return input;
        }

        if(input[idx]>input[jdx]){
            int temp = input[idx];
            input[idx] =  input[jdx];
            input[jdx] =  temp;
            idx =  jdx;
            jdx =  jdx+1;
        }else{
            jdx = jdx+1;
            if(jdx == input.length){
                idx =  idx+1;
                jdx = idx+1;
            }
        }

    return sort(input,idx,jdx);

    }
}
