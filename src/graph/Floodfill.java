package src.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Floodfill {

    static class Pair{
        int row;
        int col;

        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }



    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int intialColor = image[sr][sc];
        image[sr][sc] = color;
        if(intialColor == color) return image;
        dfs(image,sr,sc,intialColor,color);
        return image;
    }

    public static void dfs(int[][] image, int sr, int sc, int intialColor, int newcolor){
        List<Pair> pairList  = new ArrayList<>();
        Pair p1 = new Pair(0,-1);
        Pair p2 = new Pair(1,0);
        Pair p3 = new Pair(0,1);
        Pair p4 = new Pair(-1,0);
        pairList.add(p1);
        pairList.add(p2);
        pairList.add(p3);
        pairList.add(p4);

         for(int idx =0; idx < pairList.size(); idx++){
             int rowdx = pairList.get(idx).row +sr;
             int coldx = pairList.get(idx).col +sc;

             if(rowdx>=0 && rowdx< image.length && coldx >=0 && coldx< image[0].length
               && image[rowdx][coldx] == intialColor){
                 image[rowdx][coldx] =  newcolor;
                 dfs(image,rowdx,coldx,intialColor,newcolor);
             }

         }

    }

    public static void main(String[] args) {
        int[][] image = {
                {0,0, 0},
                {0, 1, 0}
        };
        int sr = 1;
        int sc = 1;
        int color = 2;

        int[][] result = floodFill(image, sr, sc, color);

        System.out.println("Flood-filled image:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }


}
