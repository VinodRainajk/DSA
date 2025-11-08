package src.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    static class Pair implements Comparable<Pair>{
        int node;
        int weight;

        public Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.weight, o.weight);

        }
    }

    public static int spanningTree(int V, int[][] edges) {
        // code here
        List<List<Pair>> graph = new ArrayList<>();

        for(int idx = 0; idx< V; idx++){
            graph.add(new ArrayList<>());
        }

        for(int idx =0 ; idx< edges.length; idx++){
                int currentNode = edges[idx][0];
                int nextNode = edges[idx][1];
                int weight=   edges[idx][2];
            graph.get(currentNode).add(new Pair(nextNode,weight));
            graph.get(nextNode).add(new Pair(currentNode,weight));
        }
        boolean[] visited = new boolean[V];
        int sum = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0) );

        while(!pq.isEmpty()){
            Pair pr = pq.remove();

            if(!visited[pr.node]){
                // I have not visited the node
                visited[pr.node] = true;
                sum = sum+pr.weight;
                for(int idx =0; idx < graph.get(pr.node).size() ; idx++){
                    if(!visited[graph.get(pr.node).get(idx).node]){
                        int nextNode =graph.get(pr.node).get(idx).node;
                        int Nextweight = graph.get(pr.node).get(idx).weight;
                        pq.add(new Pair(nextNode,Nextweight) );
                    }

                }
            }
        }
        return  sum;
    }

    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {
                {0, 1, 5},
                {1, 2, 3},
                {0, 2, 1}
        };

        int mstWeight = spanningTree(V, edges);
        System.out.println("Minimum Spanning Tree Weight: " + mstWeight);
    }

}
