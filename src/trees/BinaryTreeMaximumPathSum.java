package src.trees;

public class BinaryTreeMaximumPathSum {

    Integer maximumSum = Integer.MIN_VALUE ;
    public int maxPathSum(TreeNode root) {
        return Math.max(maxPathSumHelper(root),maximumSum);

    }
    public int maxPathSumHelper(TreeNode root)
    {
        if(root == null){
            return 0;
        }

        int leftsum =  maxPathSumHelper(root.left);
        int rightsum = maxPathSumHelper(root.right);
        maximumSum =  Math.max(leftsum+ rightsum +root.val,maximumSum);
        maximumSum = Math.max(root.val,maximumSum);
        return  Math.max(leftsum,rightsum) + root.val;
    }
}
