package src.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class primsAlgoRevision {

    class Pair implements Comparable<Pair>{
        int weight;
        int currentNode;
        int nextNode;

        public Pair( int currentNode,int nextNode, int weight) {
            this.nextNode = nextNode;
            this.currentNode = currentNode;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;

        }
    }
    public  int spanningTree(int V, int[][] edges) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        List<Boolean> visitedArray  = new ArrayList<>();
        List<List<Pair>> graph  = new ArrayList<>();
        int sum = 0;

        for(int idx=0; idx<=V; idx++){
            visitedArray.add(false);
            graph.add(new ArrayList<>());
        }

        for(int idx =0; idx < edges.length; idx++){
            Pair pair = new Pair(edges[idx][0],edges[idx][1], edges[idx][2]);
            graph.get(pair.currentNode).add(pair);
            graph.get(pair.nextNode).add(new Pair(edges[idx][1],edges[idx][0], edges[idx][2]));
        }

        pq.add( new Pair(0,0,0) );


        while(!pq.isEmpty()){
            Pair p = pq.remove();

            if( !visitedArray.get(p.currentNode) ){
                sum = sum + p.weight;
                visitedArray.set(p.currentNode,true);

                for(int idx =0 ; idx < graph.get(p.currentNode).size(); idx++){
                    Pair nodes = graph.get(p.currentNode).get(idx);
                    pq.add(new Pair(nodes.nextNode, nodes.currentNode , nodes.weight));
                }
            }



        }


        return sum;
    }

    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {
                {0, 1, 5},
                {1, 2, 3},
                {0, 2, 1}
        };
        primsAlgoRevision primsAlgRion = new primsAlgoRevision();
        int mstWeight =  primsAlgRion.spanningTree(V, edges);
        System.out.println("Minimum Spanning Tree Weight: " + mstWeight);
    }
}
