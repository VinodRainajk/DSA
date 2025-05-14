package src.trees;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root== null){
            return false;
        }

        int currentSum = targetSum- root.val;

        if(currentSum==0){
            return true;
        }

        if (hasPathSum(root.left, currentSum)){
            return true;
        }

       return hasPathSum(root.right,currentSum);
    }

}
