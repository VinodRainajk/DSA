package src.trees;

public class SortedArrayTOBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return generateToBST(nums, 0, nums.length-1);
    }

    public TreeNode generateToBST(int[] nums, int leftIndex, int rightIndex){

     if(leftIndex > rightIndex){
         return null;
     }
     int mid = (leftIndex + rightIndex)/2;
     TreeNode root = new TreeNode(nums[mid]);
     root.left  =  generateToBST(nums, leftIndex, mid-1);
     root.right =  generateToBST(nums, mid+1, rightIndex);
     return root;
    }





}
