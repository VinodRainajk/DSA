package src.trees;

import javax.sound.midi.Soundbank;
import java.util.*;

public class BSTBuilder {


    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);
        return root;
    }

    public static TreeNode buildBST(int[] values) {
        TreeNode root = null;
        for (int val : values) {
            root = insertIntoBST(root, val);
        }
        return root;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        int[] values = {5, 3, 6, 2, 4, 1}; // Ignoring null values
        TreeNode root = buildBST(values);
        System.out.println("Inorder Traversal of BST:");
        inorderTraversal(root);
        KthSmallestElement cls = new KthSmallestElement();
        System.out.println("out put is "+ cls.kthSmallest(root,3));

    }
}
