package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> res=new ArrayList<>();
      List<Integer> integerList=new ArrayList<>();
      for(int i=0;i<nums.length;++i)
          integerList.add(nums[i]);
      int len=integerList.size();
      boolean[] visited=new boolean[len];
      dfssubsets(integerList,res,0,len,visited);
      return res;
    }

    void dfssubsets(List<Integer> nums,List<List<Integer>> res,int start,int len,boolean[] visited)
    {
        if(start==len)
        {
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<len;++i)
            {
                if(visited[i]==false)
                    temp.add(nums.get(i));
            }
            res.add(temp);
            return;
        }
        visited[start]=true;
        dfssubsets(nums,res,start+1,len,visited);
        visited[start]=false;
        dfssubsets(nums,res,start+1,len,visited);
    }
}
