package src.graph;

import java.util.*;

public class KruskalALgo {

    static class Edge implements Comparable<Edge> {
        public Integer node1;
        public Integer node2;
        public Integer weight;

        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }
    }


    static List<Integer> rank = new ArrayList<>();
    static List<Integer> parent = new ArrayList<>();

    static void unionByRank(Integer node1, Integer node2){
        Integer ultparentNode1  =  findByParent(node1);
        Integer ultparentNode2 =   findByParent(node2);
        if(ultparentNode1!= ultparentNode2){
            if(rank.get(ultparentNode1) > rank.get(ultparentNode2)){
                parent.set(node2,ultparentNode1);
            } else if (rank.get(ultparentNode2) > rank.get(ultparentNode1)) {
                parent.set(node1,ultparentNode2);
            } else{
                parent.set(ultparentNode2,ultparentNode1);
                Integer rk = rank.get(ultparentNode1);
                rk++;
                rank.set(ultparentNode1,rk);
            }
        }
    }

    static Integer findByParent(Integer node){
        if( parent.get(node)== node){
            return node;
        }
       Integer utlmaiteParent = findByParent(parent.get(node));
       parent.set(node,utlmaiteParent);
       return utlmaiteParent;
    }

    public static void main(String[] args) {
        Integer V = 7;
        for(int idx = 0; idx <= V; idx++){
            rank.add(0);
            parent.add(idx);
        }
        int[][] edges = {
                {0, 1, 3},
                {1, 3, 3},
                {1, 5, 10},
                {2, 4, 6},
                {2, 6, 9},
                {3, 6, 8},
                {4, 5, 6}
        };


        List<Edge> edgeList = new ArrayList<>();
        for(int idx =0 ; idx < edges.length ; idx++){
            Edge edge = new Edge();
            edge.node1 = edges[idx][0];
            edge.node2 = edges[idx][1];
            edge.weight = edges[idx][2];
            edgeList.add(edge);
        }

        Collections.sort(edgeList);

        Integer mstWeight = 0;
        for(int idx =0; idx< edgeList.size(); idx++){

            if(findByParent(edgeList.get(idx).node1) != findByParent(edgeList.get(idx).node2)){
                mstWeight = mstWeight+edgeList.get(idx).weight;
                unionByRank(edgeList.get(idx).node1, edgeList.get(idx).node2);
            }
        }

        System.out.println(" weight "+mstWeight);
    }

}
