package src.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class SurroundedRegions {
    static class direction{
        int row;
        int col;

        public direction(int row,int col){
            this.row = row;
            this.col = col;
        }
    }

    public static  void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];


            for(int jdx =0; jdx < board[0].length; jdx++){
                int idx =0;
                if(board[idx][jdx]=='O' && !visited[idx][jdx]){
                    visited[idx][jdx] = true;
                    dfs(idx,jdx,board,visited);
                }

            }

        for(int jdx =0; jdx < board[0].length; jdx++){
            int idx =board.length-1;
            if(board[idx][jdx]=='O' && !visited[idx][jdx]){
                visited[idx][jdx] = true;
                dfs(idx,jdx,board,visited);
            }

        }

        for(int idx =0; idx < board[0].length; idx++){
            int jdx =0;
            if(board[idx][jdx]=='O' && !visited[idx][jdx]){
                visited[idx][jdx] = true;
                dfs(idx,jdx,board,visited);
            }

        }

        for(int idx =0; idx < board[0].length; idx++){
            int jdx =board[0].length-1;
            if(board[idx][jdx]=='O' && !visited[idx][jdx]){
                visited[idx][jdx] = true;
                dfs(idx,jdx,board,visited);
            }

        }





        for(int idx = 0; idx < visited.length ; idx++){
            for(int jdx =0; jdx < visited[0].length; jdx++){
                if(visited[idx][jdx]){
                    board[idx][jdx] = 'O';
                }else {
                    board[idx][jdx] = 'X';
                }

            }
        }

    }

    private static void dfs(int row, int col,char[][] board, boolean[][] visited) {
        List<direction> directionList = new ArrayList<>();
        directionList.add(new direction(0,-1));
        directionList.add(new direction(0,1));
        directionList.add(new direction(-1,0));
        directionList.add(new direction(1,0));

        for(int idx =0 ; idx < directionList.size() ; idx++){
            int currRow = row + directionList.get(idx).row;
            int currCol = col + directionList.get(idx).col;

            if(currRow >= 0 && currRow < board.length && currCol >= 0 && currCol < board[0].length
               &&  !visited[currRow][currCol] && board[currRow][currCol] =='O'){

                visited[currRow][currCol] = true;
                dfs(currRow,currCol,board,visited);
            }

        }

    }

    public static void main(String[] args) {
        char[][] image = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };

        solve(image);

        System.out.println("Flood-filled image:");
        for (char[] row : image) {
            System.out.println(Arrays.toString(row));
        }
    }
}
