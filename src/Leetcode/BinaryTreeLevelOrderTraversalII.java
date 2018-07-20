package Leetcode;

import Model.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int len=queue.size();
            List<Integer> templist=new ArrayList<>();
            while (len-->0)
            {
                TreeNode temp=((ArrayDeque<TreeNode>) queue).pop();
                templist.add(temp.val);
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }

            res.add(templist);

        }
        Collections.reverse(res);
        return res;
    }
}
