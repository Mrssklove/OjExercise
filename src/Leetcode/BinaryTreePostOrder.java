package Leetcode;

import Model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 非递归二叉树后序遍历
 * 前序  中 左 右
 * 后序  左 右 中
 */
public class BinaryTreePostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
       List<Integer> res=new ArrayList<>();
       if(root==null)
           return res;
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        while (!stack.isEmpty())
        {
            TreeNode treeNode=stack.pop();
            res.add(treeNode.val);
            if(treeNode.left!=null)
                stack.add(treeNode.left);
            if(treeNode.right!=null)
                stack.add(treeNode.right);
        }
        Collections.reverse(res);
        return res;

    }
}
