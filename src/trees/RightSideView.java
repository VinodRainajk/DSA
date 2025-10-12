package src.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    static class Pair{
        TreeNode value;
        Integer level;

        public Pair(TreeNode value,Integer level){
            this.value =value;
            this.level = level;
        }

    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> returnVal = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();

        if(root == null) return returnVal;
        Pair pr = new Pair(root, 1);
        Integer currLevel = 0;
        queue.add(pr);

        while (!queue.isEmpty()){
            pr = queue.remove();

            if(currLevel < pr.level){
                returnVal.add(pr.value.val);
                currLevel = pr.level;
            }

            if(pr.value.right != null){
                Pair prNew = new Pair(pr.value.right, pr.level+1);
                queue.add(prNew);
            }

            if(pr.value.left!= null){
                Pair prNew = new Pair(pr.value.left, pr.level+1);
                queue.add(prNew);
            }

        }

        return returnVal;

    }
}
