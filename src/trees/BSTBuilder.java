package src.trees;

import javax.sound.midi.Soundbank;
import java.util.*;

public class BSTBuilder {


    public TreeNode buildTree(Integer[] values) {
        if (values.length == 0) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }
            i++;

            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.val + " ");
            inorderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        Integer[] values = {16,14,null,4,15,1};
        BSTBuilder builder = new BSTBuilder();
        TreeNode root = builder.buildTree(values);

        System.out.println("Inorder Traversal:");
        builder.inorderTraversal(root);
        ClosestNodeQueries bst =  new ClosestNodeQueries();
        bst.closestNodes(root,Arrays.asList(10));
    }

}
