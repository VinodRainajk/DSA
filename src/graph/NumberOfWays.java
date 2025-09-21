package src.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWays {
    static class Pair{
        int nextNode;
        Long weight ;
    }
    public int countPaths(int n, int[][] roads) {

        List<List<Pair>> graph = new ArrayList<>();
        List<Long> distance = new ArrayList<>();
        List<Integer> ways = new ArrayList<>();
        for(int idx =0; idx < n ; idx++) {
            graph.add(new ArrayList<>());
            ways.add(0);
            distance.add(Long.MAX_VALUE);
        }

        for(int idx =0; idx < roads.length ; idx++) {
            Pair pair = new Pair();
            pair.nextNode = roads[idx][1];
            pair.weight = Long.valueOf(roads[idx][2]);
            List<Pair> existing = graph.get(roads[idx][0]);
            existing.add(pair);
            graph.set(roads[idx][0], existing);

            Pair pairrev = new Pair();
            pairrev.nextNode = roads[idx][0];
            pairrev.weight = Long.valueOf(roads[idx][2]);
            List<Pair> existingRev = graph.get(roads[idx][1]);
            existingRev.add(pairrev);
            graph.set(roads[idx][1], existingRev);

        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.weight, b.weight));
        Pair pr = new Pair();
        pr.weight = 0L;
        pr.nextNode= 0;
        pq.add(pr);
        distance.set(0,0L);
        ways.set(0,1);

        int mod = (int)(1e9+7);
        while(!pq.isEmpty()){
            Pair currPair = pq.remove();
            // System.out.println("currPair.nextNode "+currPair.nextNode);
            //  System.out.println("currPair.weight "+currPair.weight);
            for(int idx =0; idx< graph.get(currPair.nextNode).size(); idx++){
                Pair nextPair = graph.get(currPair.nextNode).get(idx);
                //  System.out.println("nextPair.nextNode "+currPair.nextNode);
                // System.out.println("nextPair.weight "+currPair.weight);
                if(nextPair.weight + currPair.weight < distance.get(nextPair.nextNode))
                {
                    Pair newPair = new Pair();
                    newPair.weight = nextPair.weight + currPair.weight;
                    newPair.nextNode = nextPair.nextNode;
                    pq.add(newPair);
                    ways.set(nextPair.nextNode,ways.get(currPair.nextNode));

                    distance.set(nextPair.nextNode, newPair.weight);
                } else if( nextPair.weight + currPair.weight == distance.get(nextPair.nextNode))
                {
                    Integer existingWays = (ways.get(nextPair.nextNode)+ ways.get(currPair.nextNode))%mod;
                    ways.set(nextPair.nextNode,existingWays);

                }

            }

        }

        return  ways.get(n-1);
    }

    public static void main(String[] args) {
        NumberOfWays  n = new NumberOfWays();
        int[][] edges = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        System.out.println(n.countPaths(7, edges));
    }
}
