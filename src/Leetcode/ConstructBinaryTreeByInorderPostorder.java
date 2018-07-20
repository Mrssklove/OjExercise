package Leetcode;

import Model.TreeNode;

import java.util.Arrays;

/**
 * 根据中序和构造构造
 */
public class ConstructBinaryTreeByInorderPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||inorder.length==0||postorder==null||postorder.length==0)
            return null;
        int val=postorder[postorder.length-1];
        TreeNode root=new TreeNode(val);
        int index=0;
        for(;index<inorder.length;++index)
            if(inorder[index]==val)
                break;
        //分割中序数组
        int[] leftinorder= Arrays.copyOfRange(inorder,0,index);
        int[] rightinorder=Arrays.copyOfRange(inorder,index+1,inorder.length);
        //分割后序数组
        int[] leftpostorder=Arrays.copyOfRange(postorder,0,leftinorder.length);
        int[] rightpostorder=Arrays.copyOfRange(postorder,leftinorder.length,postorder.length-1);
        root.left=buildTree(leftinorder,leftpostorder);
        root.right=buildTree(rightinorder,rightpostorder);
        return root;
    }
}
