package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
      int[] nums=new int[n];
      for(int i=0;i<n;i++)
          nums[i]=i+1;
      List<List<Integer>> res=new ArrayList<>();
      List<Integer> temp=new ArrayList<>();
      if(k>n||n==0)
          return res;
      dfsombine(nums,res,temp,k,0,0);
      return res;
    }

    public void dfsombine(int[] nums,List<List<Integer>> res,List<Integer> temp,int k,int start,int len)
    {
        if(len==k)
        {
            List<Integer> tt=new ArrayList<>();
            tt.addAll(temp);
            res.add(tt);
            return;
        }
        if(start>=nums.length)
        {
            return;
        }
        temp.add(nums[start]);
        dfsombine(nums,res,temp,k,start+1,len+1);
        temp.remove(temp.size()-1);
        dfsombine(nums,res,temp,k,start+1,len);
    }
}
