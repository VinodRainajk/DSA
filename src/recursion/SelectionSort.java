package src.recursion;

public class SelectionSort {
    public static void main(String[] args) {
        int [] input = {1,7,2,9,45,12,17};

        int []  ret = sort(input,0,input.length-1, input.length-1);

        for(int k=0 ;  k<ret.length ; k++){
            System.out.println(ret[k]);
        }

    }

    public static int[] sort(int[] input, int idx,  int lengthIdx, int maxIndx){

       if(lengthIdx==0)
       {
           return input;
       }

       if(idx==lengthIdx){
           int temp = input[lengthIdx];
           input[lengthIdx] = input[maxIndx];
           input[maxIndx] = temp;
           return sort(input,0,lengthIdx-1,lengthIdx-1);
       }else {
           if(input[idx] > input[maxIndx]){
               maxIndx = idx;
           }
           return sort(input,idx+1,lengthIdx,maxIndx);
       }

    }
}
