package Leetcode;

import Model.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
       if(root==null)
           return true;
       int left=1+heigth(root.left);
       int right=1+heigth(root.right);
       boolean flag=true;
       if(Math.abs(left-right)>1)
           flag=false;
       return flag&&isBalanced(root.right)&&isBalanced(root.left);
    }

    public int heigth(TreeNode root)
    {
        if(root==null)
            return 0;
        return 1+Math.max(heigth(root.left),heigth(root.right));
    }
}
