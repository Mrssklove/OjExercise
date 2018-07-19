package Leetcode;

import Model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        if(root==null)
            return res;
        queue.add(root);
        while (queue.isEmpty()==false)
        {
            int len=queue.size();
            List<Integer> temp=new ArrayList<>();
            while (len-->0)
            {
                TreeNode  popnode=((ArrayDeque<TreeNode>) queue).pop();
                temp.add(popnode.val);
                if(popnode.left!=null)
                    queue.add(popnode.left);
                if(popnode.right!=null)
                    queue.add(popnode.right);
            }
            res.add(temp);
        }
        return res;
    }
}
