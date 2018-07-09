package 秋招2017;

import Model.TreeNode;

import java.util.*;

/**
 * 层次遍历 每层列表返回 辅助队列即可
 */
public class 层次遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        Deque<TreeNode> queue=new ArrayDeque<>();
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        queue.add(root);
        while (!queue.isEmpty())
        {
           int len=queue.size();
           List<Integer> temp=new ArrayList<>();
           while (len-->0)
           {
               TreeNode treeNode= queue.pop();
               temp.add(treeNode.val);
               if(treeNode.left!=null)
                    queue.add(treeNode.left);
               if(treeNode.right!=null)
                    queue.add(treeNode.right);
           }
           result.add(temp);
        }
        return result;
    }
}
