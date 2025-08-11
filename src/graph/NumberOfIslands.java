package src.graph;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class NumberOfIslands {

    static class Pair{
        int row;
        int col;

        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }

    }

    public int numIslands(char[][] grid) {
        int returnIslandCount =0;
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];

        for(int idx = 0; idx < grid.length; idx++)
        {
            for(int jdx = 0; jdx < grid[idx].length ; jdx++ ){

                if(!visited[idx][jdx] && grid[idx][jdx] =='1'){
                    returnIslandCount++;
                    dfs(idx,jdx,grid,visited);
                }
            }
        }

        return returnIslandCount;
    }

    private void dfs(int row, int col, char[][] grid, boolean[][] visited) {

        Queue<Pair> currentChilds = new LinkedList<Pair>();
        Pair currPair = new Pair(row,col);
        currentChilds.add(currPair);

        List<Pair> adjecentNodes = new ArrayList<>();
        Pair leftNode = new Pair(0,-1);
        adjecentNodes.add(leftNode);
        Pair rightNode = new Pair(0,1);
        adjecentNodes.add(rightNode);
        Pair topNode = new Pair(-1,0);
        adjecentNodes.add(topNode);
        Pair downNode = new Pair(+1,0);
        adjecentNodes.add(downNode);

        while(!currentChilds.isEmpty()){

            int currRow =  currentChilds.peek().row;
            int currCol = currentChilds.peek().col;
            currentChilds.remove();

            for(int idx =  0 ; idx < adjecentNodes.size() ; idx++){

                int r = currRow + adjecentNodes.get(idx).row;
                int c = currCol + adjecentNodes.get(idx).col;

                if(r >= 0 && r <grid.length && c >= 0 && c< grid[r].length && !visited[r][c] && grid[r][c] == '1'){
                    visited[r][c] = true;
                    Pair newpair = new Pair(r,c);
                    currentChilds.add(newpair);
                }

            }

        }

    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        NumberOfIslands solver = new NumberOfIslands();
        int result = solver.numIslands(grid);
        System.out.println("Number of Islands: " + result);  // Expected Output: 1

    }
}
