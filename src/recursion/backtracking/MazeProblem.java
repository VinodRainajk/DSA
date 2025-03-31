package src.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static src.recursion.backtracking.MazeProblem.pathValue;

public class MazeProblem {

    public static void main(String[] args) {

        int[][] mazeproblem = {{1,2,3},{4,5,6},{7,8,9}};

      //  System.out.println(count(3,3));

        List<String> returnVal = new ArrayList<>();
        pathValue("",3,3,returnVal);
        System.out.println(returnVal.toString());

    }

    public static int count (int row, int column){
        if(row == 1 || column ==1){
            return 1;
        }
        int rowcount = count(row-1,column);
        int columnCount = count(row,column-1);
        return  rowcount+columnCount;
    }

    public static void pathValue (String processedPath,int row, int column, List<String> input){
        if(row == 1 && column == 1){
            input.add(processedPath);
        }
        if(row-1>=1){
            pathValue(processedPath.concat("R"),row-1,column,input);
        }

        if(column-1>=1) {
            pathValue(processedPath.concat("D"), row, column - 1, input);
        }

    }

}
