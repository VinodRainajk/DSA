package src.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    public boolean isBipartite(int[][] graph) {
        boolean[] visitedNodes = new boolean[graph.length];
        String[] nodeColors = new String[graph.length];

        for(int idx =0; idx< graph.length ; idx++){

                if(!visitedNodes[idx]){
                    visitedNodes[idx] = true;
                    nodeColors[idx] = "G";
                }
               if(! bfs(idx,graph,visitedNodes,nodeColors)){
                   return false;
               }
        }
        return true;
    }

    private boolean bfs(Integer nodeValue, int[][] graph, boolean[] visitedNodes, String[] nodeColors) {
        Queue<Integer> nodes = new LinkedList<Integer>();
        nodes.add(nodeValue);

        while(!nodes.isEmpty()){
            Integer nodeValueIDX = nodes.peek();
            nodes.remove();
            for(int idx= 0; idx< graph[nodeValueIDX].length; idx++){
                Integer currentValue = graph[nodeValueIDX][idx];
                if(!visitedNodes[currentValue] && nodeColors[currentValue]==null){
                       visitedNodes[currentValue] = true;
                        if(nodeColors[nodeValueIDX]=="G"){
                            nodeColors[currentValue]="B";
                        }else {
                            nodeColors[currentValue]="G";
                        }
                        nodes.add(graph[nodeValueIDX][idx]);
                    }else {
                    if (nodeColors[nodeValueIDX] == nodeColors[currentValue]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
