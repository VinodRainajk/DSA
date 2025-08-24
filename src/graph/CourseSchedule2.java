package src.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // graph is ready
        List<List<Integer>> courseGraph =  new ArrayList<>();
        int[] returnval = new int[numCourses];

        for(int idx = 0; idx< numCourses; idx++){
            courseGraph.add(new ArrayList<>());

        }
        int[] indegree = new int[numCourses];
        for(int idx = 0; idx < prerequisites.length; idx++){
            int course = prerequisites[idx][1];
            int preq = prerequisites[idx][0];
            courseGraph.get(course).add(preq);
            indegree[preq]++;
        }

        ;
        Queue<Integer> queue = new LinkedList<>();
        for(int idx =0 ; idx<numCourses ; idx++ ){
            if (indegree[idx]==0){
                queue.add(idx);
            }
        }

        int idx =0;
        while (!queue.isEmpty()){
            int node =   queue.remove();
            returnval[idx] = node;

            for(int jdx : courseGraph.get(node)){
                indegree[jdx]--;
                if(indegree[jdx]==0){
                    queue.add(jdx);
                }
            }
            idx++;
        }
        if(idx == numCourses){
            return returnval;
        }else{
            return new int[]{};
        }



    }







}
