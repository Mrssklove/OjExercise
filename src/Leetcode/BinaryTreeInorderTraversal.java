package Leetcode;

import Model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归中序遍历
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty()||root!=null)
        {
            while (root!=null)
            {
                stack.add(root);
                root=root.left;
            }
            TreeNode temp=stack.pop();
            res.add(temp.val);
            root=temp.right;
        }
        return res;
    }
}
