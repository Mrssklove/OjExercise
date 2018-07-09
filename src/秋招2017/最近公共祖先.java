package 秋招2017;

import Model.TreeNode;

/**
 * LCS   左右开始遍历找第一个结点
 */
public class 最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root==null)
            return null;
        if(root==A||root==B)
            return root;

        TreeNode left=lowestCommonAncestor(root.left,A,B);
        TreeNode right=lowestCommonAncestor(root.right,A,B);

        if(left!=null&&right!=null)
            return root;
        else if(left==null)
            return right;
        else if(right==null)
            return left;
        return null;

    }
}
