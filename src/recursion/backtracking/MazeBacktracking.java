package src.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class MazeBacktracking {
    public static void main(String[] args) {
        boolean[][] mazeproblem = {{true,true,true},{true,true,true},{true,true,true}};
        System.out.println(mazeWithRestrictionSolution(mazeproblem,"",0,0).toString());
    }

    public static List<String> mazeWithRestrictionSolution(boolean[][] input, String processed, int row, int column){

        if(row==2 && column==2){
            List<String> returnval = new ArrayList<>();
            returnval.add(processed);
            return returnval;
        }



        List<String> rowvalue = new ArrayList<>();
        List<String> columnValue = new ArrayList<>();

        if(!input[row][column]){
            return new ArrayList<>();
        }

        input[row][column] = false;


        if(row< input.length-1){
            rowvalue.addAll(mazeWithRestrictionSolution(input,processed.concat("R"), row+1,column));
        }

        if(column< input[0].length-1) {
            columnValue.addAll(mazeWithRestrictionSolution(input, processed.concat("D"), row, column + 1));
        }

        if(row>0){
            rowvalue.addAll(mazeWithRestrictionSolution(input,processed.concat("L"), row-1,column));
        }

        if(column>0) {
            columnValue.addAll(mazeWithRestrictionSolution(input, processed.concat("U"), row, column - 1));
        }


        input[row][column] = true;
        rowvalue.addAll(columnValue);
        return rowvalue;

    }
}
