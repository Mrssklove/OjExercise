package Leetcode;

import Model.TreeNode;

/**
 * BinaryTree To LinkedList
 *
 *
 */
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        if(root.left==null&&root.right==null)
        {
            return;
        }
        TreeNode temp=root.left;
        flatten(root.left);
        flatten(root.right);
        if(temp==null)
            return;
        for(;temp.right!=null;temp=temp.right);
        if(temp!=null)
            temp.right=root.right;
        root.right=root.left;
        root.left=null;

    }
}
