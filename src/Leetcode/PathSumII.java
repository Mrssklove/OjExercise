package Leetcode;

import Model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>> res=new ArrayList<>();
      List<Integer> temp=new ArrayList<>();
      dfspathSum(root,res,temp,0,sum);
      return res;
    }

    private void dfspathSum(TreeNode root,List<List<Integer>> res,List<Integer> temp,int value,int sum)
    {
        if(root==null)
            return;
        if(root.left==null&&root.right==null)
        {
            temp.add(root.val);
            value+=root.val;
            if(sum==value)
            {
                List<Integer> t=new ArrayList<>();
                t.addAll(temp);
                res.add(t);
            }
            value-=root.val;
            temp.remove(temp.size()-1);
            return;
        }
        temp.add(root.val);
        value+=root.val;
        dfspathSum(root.left,res,temp,value,sum);
        dfspathSum(root.right,res,temp,value,sum);
        temp.remove(temp.size()-1);
    }
}
