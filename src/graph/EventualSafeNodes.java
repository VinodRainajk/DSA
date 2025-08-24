package src.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EventualSafeNodes {

    public static boolean dfs(int node, int[][] graph, boolean[] visitedNodes, boolean[] pathVisited,Set<Integer> retval ){

        if(!visitedNodes[node]){
            visitedNodes[node] = true;
            pathVisited[node] = true;
            for(int idx = 0 ; idx< graph[node].length; idx++){
             if(!dfs(graph[node][idx],graph,visitedNodes,pathVisited,retval)){
                 return false;
             }
            }
        } else if (pathVisited[node]) {
            // cycle Detected
            return false;
        }
        pathVisited[node] = false;
        retval.add(node);
        return true;
    }


    public static List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visitedNodes = new boolean[graph.length];
        boolean[] pathVisited  = new boolean[graph.length];
        Set<Integer> retval = new HashSet<>();
        for(int idx = 0; idx < graph.length ; idx++){
            dfs(idx,graph, visitedNodes, pathVisited,retval);
        }
        return retval.stream().sorted().toList();
    }

    public static void main(String[] args) {
        int[][] image = {
                {1,2},
                {2,3},
                {5},
                {0},
                {5},
                {},
                {}
        };


        System.out.println("Flood-filled image:" + eventualSafeNodes(image));

    }
}
