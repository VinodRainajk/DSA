package src.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DistinctIslands {

    static class direction{
        int row;
        int col;

        public direction(int row,int col){
            this.row = row;
            this.col = col;
        }
    }

    static int countDistinctIslands(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visitedArray = new boolean[row][col];
        HashSet<List<String>> set = new HashSet<>();
        for(int idx =0; idx < row; idx++)
            for(int jdx =0; jdx < col; jdx++){
                List<String> route = new ArrayList<>();
                if(!visitedArray[idx][jdx] && grid[idx][jdx]==1){


                    dfs(idx,jdx,route,grid,idx,jdx,visitedArray);
                    set.add(route);
                }
            }
      return set.size();
    }

    private static String toString(int i, int j) {
        return Integer.toString(i)+" "+Integer.toString(j);
    }

    private static void  dfs(int mainRow, int mainCol, List<String> route, int[][] grid, int row, int col,boolean[][] visitedArray) {
        visitedArray[row][col] = true;
        List<direction> directionList = new ArrayList<>();
        directionList.add(new direction(0,-1));
        directionList.add(new direction(0,1));
        directionList.add(new direction(-1,0));
        directionList.add(new direction(1,0));

        route.add(toString(mainRow-row,mainCol-col));

        for(int idx =0 ; idx< directionList.size(); idx++){
            int currRow = directionList.get(idx).row + row;
            int currCol = directionList.get(idx).col+ col;
            if(currRow>= 0 && currRow < grid.length && currCol >= 0 && currCol< grid[0].length
                &&!visitedArray[currRow][currCol] && grid[currRow][currCol]==1)
            {
                dfs(mainRow,mainCol,route,grid,currRow,currCol,visitedArray);
            }
        }


    }


    public static void main(String[] args) {

        int[][] image = {
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}
    };
        countDistinctIslands(image);
        System.out.println("Flood-filled image: "+countDistinctIslands(image));
    }
}
