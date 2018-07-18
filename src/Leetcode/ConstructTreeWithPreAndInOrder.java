package Leetcode;

import Model.TreeNode;

import java.util.Arrays;

/**
 * 根据前序  中序构造二叉树
 * 注意Length=0与null
 */
public class ConstructTreeWithPreAndInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.length==0||inorder.length==0)
            return null;
        TreeNode root=new TreeNode(preorder[0]);
        int inorderindex=0;
        int inorderlen=inorder.length;
        for(inorderindex=0;inorderindex<inorderlen;inorderindex++)
            if(inorder[inorderindex]==preorder[0])
                break;
        //切分中序数组
        int[] leftinorder=Arrays.copyOfRange(inorder,0,inorderindex);
        int[] rightinorder=Arrays.copyOfRange(inorder,inorderindex+1,inorderlen);
        //切分前序数组
        int[] leftpreorder=Arrays.copyOfRange(preorder,1,leftinorder.length+1);
        int[] rightpreorder=Arrays.copyOfRange(preorder,1+leftinorder.length,preorder.length);
        root.left=buildTree(leftpreorder,leftinorder);
        root.right=buildTree(rightpreorder,rightinorder);
        return root;
    }
}
