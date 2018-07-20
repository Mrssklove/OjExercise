package Leetcode;

import Model.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean isleft=false;
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
            if(isleft)
            {
                Collections.reverse(templist);
                res.add(templist);
            }
            else
                res.add(templist);
            isleft=!isleft;
        }
        return res;
    }
}
