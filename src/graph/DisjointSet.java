package src.graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();

    public DisjointSet(int nodes){
      for(int idx =0; idx <= nodes; idx++){
          parent.add(idx);
          rank.add(0);
      }
    }

    public Integer findParent(Integer node){
        if(node == parent.get(node)){
            return node;
        }
        Integer ultimateParent= findParent(parent.get(node)); // need to do path compression so that i dont have to recompute again in next Iteration
        parent.set(node,ultimateParent);
        return ultimateParent;
    }

    public void unionByRank(Integer node1, Integer node2){
        Integer parent1 = findParent(node1);
        Integer parent2 = findParent(node2);
        if(parent1 != parent2){
            if(rank.get(parent1) > rank.get(parent2)){
                parent.set(parent2,parent1);
            } else if (rank.get(parent1) < rank.get(parent2)) {
                parent.set(parent1,parent2);
            }else{
                parent.set(parent2,parent1);
                int rankValue = rank.get(parent1);
                rankValue++;
                rank.set(parent1,rankValue);
            }
        }
    }

    public static void main(String[] args) {
        DisjointSet dsj = new DisjointSet(7);
        dsj.unionByRank(1,2);
        dsj.unionByRank(2,3);
        dsj.unionByRank(4,5);
        dsj.unionByRank(6,7);
        dsj.unionByRank(5,6);

        if(dsj.findParent(3) != dsj.findParent(7)){
            System.out.println("Not same Parent");
        }
        dsj.unionByRank(3,7);

        if(dsj.findParent(3) == dsj.findParent(7)){
            System.out.println("same Parent");
        }
    }

}
