package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列 递归交换
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> numlist=new ArrayList<>();
        for(int i=0;i<nums.length;++i)
            numlist.add(nums[i]);
        dfspermute(numlist,0,numlist.size(),res);
        return res;
    }


    public void dfspermute(List<Integer> nums,int start,int len,List<List<Integer>> res)
    {
        if(start>=len)
        {
            List<Integer> temp=new ArrayList<>();
            temp.addAll(nums);
            res.add(temp);
            return;
        }
        for(int i=start;i<len;++i)
        {
            swap(nums,start,i);
            int tt=start+1;
            dfspermute(nums,tt,len,res);
            swap(nums,i,start);
        }
    }

    public void swap(List<Integer> list, int i, int j)
    {
        int temp=list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    };
}
