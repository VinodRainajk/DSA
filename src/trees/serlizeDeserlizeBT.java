package src.trees;

import java.util.ArrayList;
import java.util.List;

public class serlizeDeserlizeBT {


    public String serialize(TreeNode root) {
        if(root==null){
            return "Null";
        }
        String leftSide = String.valueOf(root.val) + ","+serialize(root.left);
        return  leftSide + ","+serialize(root.right);
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arrVal  =  data.split(",");
        if(arrVal.length ==0){
         return null;
        }
        List<String> input = new ArrayList<>();
        for(int jdx = 0 ; jdx< arrVal.length; jdx++){
            input.add(0,arrVal[jdx]);
        }

        return deserializeHelper(input);
    }

    public TreeNode deserializeHelper(List<String> input){
        if(input.isEmpty()){
            return null;
        }

        String val =  input.remove(input.size()-1);
        if(val.equals("Null")){
            return null;
        }

        TreeNode currNode = new TreeNode(Integer.parseInt(val));
        currNode.left = deserializeHelper(input);
        currNode.right = deserializeHelper(input);
        return  currNode;
    }


}
