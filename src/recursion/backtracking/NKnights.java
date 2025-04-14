package src.recursion.backtracking;

import java.sql.SQLOutput;

public class NKnights {

    public static void main(String[] args) {
    int n= 4;
    boolean[][] board = new boolean[n][n];
        System.out.println(nknightsSolution(board, 0, 0, 4));
    }


    public static int nknightsSolution(boolean[][] board, int row, int col, int Knights){

        if(Knights == 0) {
            displayknightsS(board);
            return 1;

        }

        if(col==board.length){
            row = row+1;
            col = 0;
            nknightsSolution(board,row,col,Knights);
        }

           if(iSafe(board,row,col)){
                board[row][col] = true;
                nknightsSolution(board,row,col+1,Knights-1);
                board[row][col] = false;
            }

           nknightsSolution(board,row,col+1,Knights);

        return 1;
    }

    public static boolean iSafe(boolean[][] board, int row, int col){

        if(iSvalidPosition(board,row-2,col-1)){
            if(board[row-2][col-1]){
                return false;
            }
        }

        if(iSvalidPosition(board,row-2,col+1)){
            if(board[row-2][col+1]){
                return false;
            }
        }

        if(iSvalidPosition(board,row-1,col-2)){
            if(board[row-2][col-1]){
                return false;
            }
        }

        if(iSvalidPosition(board,row-1,col+2)){
            if(board[row-1][col+2]){
                return false;
            }
        }

        return true;
    }

    public static boolean iSvalidPosition(boolean[][] board, int rowPosition, int colPosition){

        if(rowPosition > board.length || rowPosition <= 0 || colPosition > board.length || colPosition<0){
            return false;
        }

        return true;
    }


private static void displayknightsS(boolean[][] knights) {

    for(int idx = 0; idx< knights.length; idx++ ){

        for(int jdx =0; jdx < knights[idx].length; jdx++){

            if(knights[idx][jdx]){
                System.out.print("Q");
            }else {
                System.out.print("X");
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    }
}
