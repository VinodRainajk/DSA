package src.LinearSearch;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sortedmatrix {

    public static void main(String[] args) {
        int[][] accountDetails =  {
                                   {10, 20, 30, 40},
                                   {15, 25, 35, 45},
                                   {28, 29, 37, 49},
                                   {33, 34, 38, 50}
                            };
    System.out.println(Arrays.toString(searchInMatrix(accountDetails,10)));
    }


    public static int[]searchInMatrix(int[][] matrix, int target){

        int row = 0;
        int col = matrix.length-1;

        while(col>=0 && row < matrix.length){
            if(matrix[row][col] == target)
                return new int[]{row,col};
            else {
                if(matrix[row][col] > target) col--;
                else row++;
            }

        }
        return new int[]{-1,-1};
    }

}
