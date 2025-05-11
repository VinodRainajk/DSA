package src.trees;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root)
    {
        if(root == null){
            return root;
        }

        TreeNode leftChild =  invertTree(root.left);
        TreeNode rightChild = invertTree(root.right);
        root.right = leftChild;
        root.left = rightChild;
        return root;
    }

}
