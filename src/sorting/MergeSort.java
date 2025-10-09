package src.sorting;

public class MergeSort {


    int[] mergeSortArray(int arr[], int l, int r){
        if(l==r){
            return new int[]{arr[l]};
        }

       int mid = l + (r-l)/2;
       int[] left = mergeSortArray(arr,l,mid);
       int[] right =  mergeSortArray(arr,mid+1,r);
       int[] merged =  new int[left.length + right.length];
       int maxLength = left.length+right.length;//Math.max(left.length,right.length);
       int idx =0;
       int leftidx = 0;
       int rightidx = 0;
       while(idx < maxLength){

           if(leftidx<left.length &&   rightidx < right.length){
               if(left[leftidx]< right[rightidx]){
                   merged[idx] = left[leftidx];
                   leftidx++;
               } else if (left[leftidx]> right[rightidx]) {
                   merged[idx] = right[rightidx];
                   rightidx++;
               }else {
                   merged[idx] = left[leftidx];
                   idx++;
                   merged[idx] = right[rightidx];
                   leftidx++;
                   rightidx++;
               }
           }else {
               if (leftidx == left.length) {
                   merged[idx] = right[rightidx];
                   rightidx++;
               } else {
                   merged[idx] = left[leftidx];
                   leftidx++;
               }
           }
           idx++;
       }
     return merged;
    }


    int[] mergeSortArrayInPlace(int arr[], int l, int r){
        if(l==r){
            return new int[]{arr[l]};
        }

        int mid = l + (r-l)/2;
        int[] left = mergeSortArray(arr,l,mid);
        int[] right =  mergeSortArray(arr,mid+1,r);
        int[] merged =  new int[left.length + right.length];
        int maxLength = left.length+right.length;//Math.max(left.length,right.length);
        int idx =0;
        int leftidx = 0;
        int rightidx = 0;
        while(idx < maxLength){

            if(leftidx<left.length &&   rightidx < right.length){
                if(left[leftidx]< right[rightidx]){
                    merged[idx] = left[leftidx];
                    leftidx++;
                } else if (left[leftidx]> right[rightidx]) {
                    merged[idx] = right[rightidx];
                    rightidx++;
                }else {
                    merged[idx] = left[leftidx];
                    idx++;
                    merged[idx] = right[rightidx];
                    leftidx++;
                    rightidx++;
                }
            }else {
                if (leftidx == left.length) {
                    merged[idx] = right[rightidx];
                    rightidx++;
                } else {
                    merged[idx] = left[leftidx];
                    leftidx++;
                }
            }
            idx++;
        }
        return merged;
    }
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr =  new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] retu=mergeSort.mergeSortArray(arr,0,9);
        System.out.println(retu);
    }

}
