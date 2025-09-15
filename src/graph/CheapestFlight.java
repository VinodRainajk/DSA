package src.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlight {
    static class Pair{
        int node;
        int weight;
        int stops;
    }

    static class Dest{
        int nextStop;
        int weight;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<Pair> pq = new LinkedList<>();
        List<List<Dest>> nodesList = new ArrayList<>();
        int[] distance = new int[n];

        for(int idx =0; idx< n; idx++){
            nodesList.add(new ArrayList<>());
            distance[idx] = (int)1e9;
        }

        for(int idx =0; idx< flights.length; idx++){
            Dest dest = new Dest();
            dest.nextStop = flights[idx][1];
            dest.weight = flights[idx][2];
            nodesList.get(flights[idx][0]).add(dest);

            if(src==flights[idx][0]){
                Pair pr =  new Pair();
                pr.node = flights[idx][1];
                pr.weight = flights[idx][2];
                pr.stops = 0;
                pq.add(pr);
                distance[src] = 0;
                distance[flights[idx][1]] = flights[idx][2];
            }
        }

        while(!pq.isEmpty()){
            Pair pair = pq.remove();
            if(pair.stops+1 <= k){
                for(int idx = 0 ; idx < nodesList.get(pair.node).size(); idx++ ){
                    int nextNode = nodesList.get(pair.node).get(idx).nextStop;
                    int nextStopWeight = nodesList.get(pair.node).get(idx).weight  + pair.weight;
                    if(  nextStopWeight < distance[nextNode]  ){
                        distance[nextNode] = nextStopWeight;
                        Pair pr =  new Pair();
                        pr.node = nextNode;
                        pr.weight = nextStopWeight;
                        pr.stops = pair.stops+1;
                        pq.add(pr);
                    }
                }
            }
        }

        if(distance[dst] == (int)1e9){
            return -1  ;
        }
        return    distance[dst];
    }
}
