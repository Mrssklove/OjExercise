package Leetcode;

import Model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 左右子树为空时 即返回
 */
public class SumRoottoLeaf {
    static int sum;
    public int sumNumbers(TreeNode root) {
        sum=0;
        List<Integer> temp=new ArrayList<>();
        dfsTree(root,temp);
        return sum;
    }

    public void dfsTree(TreeNode root,List<Integer> temp)
    {
        if(root==null)
            return;
        if(root.left==null&&root.right==null)
        {
            temp.add(root.val);
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<temp.size();i++)
                sb.append(temp.get(i));
            sum+=Integer.parseInt(sb.toString());
            temp.remove(temp.size()-1);
            return;
        }
        temp.add(root.val);
        dfsTree(root.left,temp);
        dfsTree(root.right,temp);
        temp.remove(temp.size()-1);
    }
}
