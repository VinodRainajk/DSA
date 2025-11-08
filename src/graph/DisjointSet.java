package src.graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int length){
      for(int idx =0; idx <= length; idx++){
          rank.add(0);
          parent.add(idx);
      }
    }

    public int findParent(int value){
        if(parent.get(value)==value){
            return value;
        }
        int currentParent = parent.get(value);
        int ultParent =  findParent(currentParent);
        parent.set(currentParent,ultParent);
        return ultParent;
    }

    public void unionByRank(int val1, int val2 ){
        int parent1 = findParent(val1);
        int parent2=  findParent(val2);

        if(rank.get(val1) > rank.get(val2)){
            parent.set(val2,val1);

        } else if (rank.get(val1) < rank.get(val2)) {
            parent.set(val1,val2);
        }
        else{

            int currentRank =   rank.get(val1);
            currentRank = currentRank+1;
            rank.set(val1, currentRank);
            parent.set(val2,val1);
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
