package src.graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvince {
    public static int findCircleNum(int[][] isConnected) {

        List<List<Integer>> adjList = new ArrayList<>();
        for(int idx=0; idx< isConnected.length ; idx++){
            List<Integer> arr = new ArrayList<>();
            for(int jdx= 0; jdx < isConnected[idx].length ; jdx++){
                if(isConnected[idx][jdx]==1 && idx !=jdx){
                    arr.add(jdx);
                }
            }
            adjList.add(arr);
        }

        boolean[] visited = new boolean[adjList.size()];
        int returnNodeCount = 0;
        for(int idx =0; idx < adjList.size() ; idx++){
            if(!visited[idx]){
                returnNodeCount ++;
                dfs(idx,adjList, visited );
            }
        }
        return returnNodeCount;

    }

    public static  void dfs(Integer node, List<List<Integer>> adj , boolean[] visited){
        visited[node] = true;
        List<Integer> adjNodes = adj.get(node);
        for(int idx = 0 ; idx < adjNodes.size(); idx++){
            if(!visited[adjNodes.get(idx)]){
                dfs(adjNodes.get(idx),adj, visited );
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };


        findCircleNum(isConnected);
    }
}
