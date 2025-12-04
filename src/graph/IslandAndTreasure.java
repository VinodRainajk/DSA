package src.graph;

import java.util.*;

public class IslandAndTreasure {
    static class DirectionPair{
        int row;
        int col;
        public DirectionPair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    static class WeightPair{
        int row;
        int col;
        int weight;
        public WeightPair(int row, int col, int weight){
            this.row = row;
            this.col = col;
            this.weight = weight;
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;


        List<DirectionPair> directions = new ArrayList<>();
        DirectionPair p1 = new DirectionPair(0,-1);
        directions.add(p1);
        DirectionPair p2 = new DirectionPair(0,1);
        directions.add(p2);
        DirectionPair p3 = new DirectionPair(-1,0);
        directions.add(p3);
        DirectionPair p4 = new DirectionPair(1,0);
        directions.add(p4);

        Queue<WeightPair> q = new LinkedList<>();

        for(int idx =0 ; idx < maxRow; idx++){
            for(int jdx =0 ; jdx < maxCol; jdx++){

            if(grid[idx][jdx]==0){
                boolean[][] visited = new boolean[maxRow][maxCol];
                visited[idx][jdx] = true;
                WeightPair masterWP = new WeightPair(idx, jdx, 0);
                q.add(masterWP);

                while(!q.isEmpty()){
                    WeightPair qval = q.remove();

                    for(int sdx = 0; sdx < directions.size() ; sdx++){
                        int currRow = qval.row + directions.get(sdx).row;
                        int currCOl = qval.col + directions.get(sdx).col;
                        int currWeight = qval.weight +1;

                        if(currRow >=0 && currRow < maxRow && currCOl>=0 && currCOl < maxCol
                          && grid[currRow][currCOl] > currWeight && grid[currRow][currCOl] != -1 && grid[currRow][currCOl] !=0 && !visited[currRow][currCOl]){
                                grid[currRow][currCOl] =   currWeight;
                                WeightPair childWP = new WeightPair(currRow, currCOl, currWeight);
                                q.add(childWP);
                                visited[currRow][currCOl] = true;
                        }


                    }

                }



            }
            }

        }


    }


    public static void main(String[] args) {
        IslandAndTreasure sol = new IslandAndTreasure();

        int INF = Integer.MAX_VALUE;
        int[][] grid = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };

        System.out.println("Before:");
        printGrid(grid);

        sol.islandsAndTreasure(grid);

        System.out.println("\nAfter:");
        printGrid(grid);
    }

    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

}
