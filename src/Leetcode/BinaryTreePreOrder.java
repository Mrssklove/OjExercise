package Leetcode;

import Model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历非递归 栈
 */
public class BinaryTreePreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        stack.add(root);
        while (!stack.isEmpty())
        {
            TreeNode node=stack.pop();
            res.add(node.val);
            if(node.right!=null)
                stack.add(node.right);
            if(node.left!=null)
                stack.add(node.left);
        }
        return res;
    }
}
