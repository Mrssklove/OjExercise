package 秋招2017;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列  -->递归交换
 * 带重复元素全排列  swap(i,j) [i,j-1]不能存在与num[j]相等的数
 */
public class 重复元素的全排列 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> res=new ArrayList<>();
        dfspermuteUnique(nums,0,res);
        return res;
    }

    public void dfspermuteUnique(int[] nums,int start,List<List<Integer>> res)
    {
        int len=nums.length;
        if(start>=len)
        {
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<nums.length;i++)
                temp.add(nums[i]);
            res.add(temp);
            return;
        }
        for(int i=start;i<len;i++)
        {
            if(iscanswap(nums,start,i))
            { swap(nums,start,i);
                int temp=start+1;
                dfspermuteUnique(nums,temp,res);
                swap(nums,i,start);}
        }
    }


    public void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public boolean iscanswap(int[] nums,int i,int j)
    {
        for(;i<j;++i)
        {
            if(nums[i]==nums[j])
                return false;
        }
        return true;
    }
}
