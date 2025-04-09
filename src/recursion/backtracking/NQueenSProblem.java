package src.recursion.backtracking;

public class NQueenSProblem {

    public static void main(String[] args) {
        System.out.println(queensProblem(new boolean[4][4],0));
    }

    public static int queensProblem(boolean[][] queen , int row){

        if(queen.length==row){
            System.out.println( "**********************************");
            displayQueen(queen);
            return 1;
        }

        int countWays = 0;
        for(int col =0; col < queen.length; col++){
            if(isValidPosition(queen,row,col)){
                queen[row][col] =  true;
                countWays = countWays + queensProblem(queen,row+1);
                queen[row][col] =  false;
            }
        }

        return countWays;
    }

    private static boolean isValidPosition(boolean[][] queen, int row, int col) {

        for(int idx = 0; idx< queen.length; idx++){
            if(queen[idx][col]){
                return false;
               }
            }

        int maxLeft = Math.min(row,col);
        for(int idx = 1; idx <= maxLeft; idx++){
            if(queen[row-idx][col-idx]){
                return false;
            }
        }

        int maxRight = Math.min(row, queen.length-col-1);
        for(int idx = 1; idx <= maxRight; idx++){
            if(queen[row-idx][col+idx]){
                return false;
            }
        }


        return true;
    }

    private static void displayQueen(boolean[][] queen) {

        for(int idx = 0; idx< queen.length; idx++ ){

            for(int jdx =0; jdx < queen[idx].length; jdx++){

                if(queen[idx][jdx]){
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
