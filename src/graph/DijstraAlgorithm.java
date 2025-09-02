package src.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijstraAlgorithm {

    static class Pair{
        int node;
        int distance;

        public Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    public static int[] dijkstra(int V, int[][] edges, int src) {

        /// Define an infinty arry for the Nodes
        int[] distance = new int[V];
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();
        for(int idx = 0; idx < V; idx++){
            distance[idx] =  (int)1e9;
            graph.add(new ArrayList<>());
        }
        /// create the connectuion Array
        for(int idx = 0 ; idx < edges.length ; idx++){
            ArrayList<Integer> edg = new ArrayList<>();
                edg.add(edges[idx][1]);
                edg.add(edges[idx][2]);

            ArrayList<Integer> rev = new ArrayList<>();
                rev.add(edges[idx][0]);
                rev.add(edges[idx][2]);
            graph.get(edges[idx][0]).add(edg); // node
            graph.get(edges[idx][1]).add(rev); // node
        }

        // Define a Priority Queue
        // Add source as 0 in pq and Distance Array
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.distance-y.distance);
        Pair pr = new Pair(src,0);
        pq.add(pr);
        distance[src] = 0;

        // Loop Pq
            // take the distnance and node
            // get the node edeges an weigth
            // add it to  existnace distance
            // if distnce is less update distnace array
            // and add to PQ
            while(!pq.isEmpty()) {
                Pair pr1 = pq.remove();
                int currDistance = pr1.distance;
                int node = pr1.node;

                for (int idx = 0; idx < graph.get(node).size(); idx++) {
                    int weight = graph.get(node).get(idx).get(1);
                    int tempNode =  graph.get(node).get(idx).get(0);
                    if ((currDistance + weight) < distance[tempNode]) {
                        distance[tempNode] = currDistance + weight;
                        Pair prq = new Pair(tempNode, currDistance + weight);
                        pq.add(prq);
                    }
                }
            }
      return distance;

    }
    // For testing
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0, 1, 4}, {0, 2, 8}, {1, 4, 6}, {2, 3, 2}, {3, 4, 10}};
        int src = 0;
        int[] result = dijkstra(V, edges, src);
        System.out.println(Arrays.toString(result)); // Output: [1000000000, 1000000000, 0]
    }


}
