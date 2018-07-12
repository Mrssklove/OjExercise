package Leetcode;

import java.util.*;

/**
 * 先排序  固定一个点 在逼近
 */
public class TwoSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        Set<List<Integer>> res=new HashSet<>();
        for(int i=0;i<len;i++)
        {
            int start=i+1;
            int end=len-1;
            while (start<end)
            {
                int tempsum=nums[i]+nums[start]+nums[end];
                if(tempsum==0)
                {
                    List<Integer> templist=new ArrayList<>();
                    templist.add(nums[i]);templist.add(nums[start]);templist.add(nums[end]);
                    res.add(templist);
                    start++;
                    end--;
                }
                else if(tempsum>0)
                {
                    end--;
                }
                else if(tempsum<0)
                {
                    start++;
                }
            }
        }
        List<List<Integer>> reslist=new ArrayList<>();
        reslist.addAll(res);
        return reslist;
    }
}
