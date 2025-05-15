package src.trees;

public class SumRootToLeaf {

    public int sumNumbers(TreeNode root) {
        return sumHelper(root,0);
    }

    public int sumHelper(TreeNode root, int currentSum){

        if(root == null ){
            return 0;
        }

        int sum = currentSum*10+ root.val;

        if(root.left == null && root.right==null){
            return sum;
        }

        return sumHelper(root.left,sum) + sumHelper(root.right,sum);
    }

}
