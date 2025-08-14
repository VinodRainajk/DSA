package src.graph;

import java.util.*;

public class NearestZeroMatrix {

    static class adjPair{
        int row;
        int col;
        int distance;

        public adjPair(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    static class direction{
        int row;
        int col;

        public direction(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    private static int[][] updateMatrix(int[][] image) {
        int row = image.length;
        int col = image[0].length;
        boolean[][] visitedMatrix = new boolean[row][col];
        int[][] resultMatrix = new int[row][col];
        Queue<adjPair> adjecencyPair = new LinkedList<adjPair>();

        for(int idx = 0; idx < row ; idx++){
            for(int jdx =0; jdx < col ; jdx++){
                if(image[idx][jdx]==0){
                    adjecencyPair.add(new adjPair(idx,jdx,0));
                    visitedMatrix[idx][jdx] = true;
                    resultMatrix[idx][jdx] = 0;
                }
            }
        }

         List<direction> directionList = new ArrayList<>();
          directionList.add(new direction(0,-1));
          directionList.add(new direction(0,1));
          directionList.add(new direction(-1,0));
          directionList.add(new direction(1,0));


          while(!adjecencyPair.isEmpty()){
                adjPair currNode = adjecencyPair.remove();

              for(int idx = 0 ; idx < directionList.size() ; idx++){
                    int currrow = currNode.row + directionList.get(idx).row;
                    int currcol = currNode.col + directionList.get(idx).col;
                    int currDistance  =  currNode.distance +1;
                    if(currrow >= 0 && currrow < image.length
                       && currcol >= 0 && currcol < image[0].length
                       && !visitedMatrix[currrow][currcol]){

                        visitedMatrix[currrow][currcol] = true;
                        resultMatrix[currrow][currcol] = currDistance;
                        adjecencyPair.add(new adjPair(currrow,currcol,currDistance));
                    }

              }


          }


    return resultMatrix;
    }





    public static void main(String[] args) {
        int[][] image = {
                {0,0, 0},
                {0, 1, 0},
                {1,1,1}
        };

        int[][] result = updateMatrix(image);

        System.out.println("Flood-filled image:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }


}
