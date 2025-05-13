package src.trees;


public class KthSmallestElement {

    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return helper(root,k).val;
    }

    public TreeNode helper(TreeNode root, int k){

        if(root==null){
            return null;
        }

        TreeNode left = helper(root.left,k);

        if (count == k){
            return root;
        }

         count++;

        return helper(root.right,k);

    }



}
