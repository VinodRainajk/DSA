package src.trees;

public class DiameterOfBinaryTree {
    int diameter =0;
    public int diameterOfBinaryTree(TreeNode root) {
        heightTree(root);
        return diameter-1;
    }

    int heightTree(TreeNode root){

        if(root== null){
            return 0;
        }

        int lefthieght = heightTree(root.left);
        int rightheight = heightTree(root.right);
        int dia = lefthieght+rightheight+1;
        diameter = Math.max(diameter,dia);
        return Math.max(lefthieght,rightheight) +1;
    }
}
