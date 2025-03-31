package src.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class MazeWithRestrictions {

    public static void main(String[] args) {
        boolean[][] mazeproblem = {{true,true,true},{true,false,true},{true,true,true}};
        System.out.println(mazeWithRestrictionSolution(mazeproblem,"",0,0).toString());
    }

   public static List<String> mazeWithRestrictionSolution(boolean[][] input, String processed, int row, int column){

        if(row==2 && column==2){
            List<String> returnval = new ArrayList<>();
            returnval.add(processed);
            return returnval;
        }

        if(input[row][column]==false){
            return new ArrayList<>();
        }

        List<String> rowvalue = new ArrayList<>();
        List<String> columnValue = new ArrayList<>();

        if(row+1< input.length){
            rowvalue.addAll(mazeWithRestrictionSolution(input,processed.concat("R"), row+1,column));
        }

       if(column+1< input[0].length) {
           columnValue.addAll(mazeWithRestrictionSolution(input, processed.concat("C"), row, column + 1));
       }

        rowvalue.addAll(columnValue);
        return rowvalue;

   }
}
