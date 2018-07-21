package Leetcode;

import Model.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
     return dfshasPathSum(root,0,sum);
    }

    private boolean dfshasPathSum(TreeNode root,int temp,int sum)
    {
        if(root==null)
            return false;
        if(root.left==null&&root.right==null)
        {
            if(temp+root.val==sum)
                return true;
            else
                return false;
        }
        return dfshasPathSum(root.left,temp+root.val,sum)||dfshasPathSum(root.right,temp+root.val,sum);
    }
}
