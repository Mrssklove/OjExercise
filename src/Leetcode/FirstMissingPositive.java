package Leetcode;

import java.util.HashMap;

/**
 * Leetcode42 HashMap
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(hashMap.containsKey(nums[i])==false)
                hashMap.put(nums[i],1);
        }
        int res=1;
        for(int i=1;i<=nums.length+1;i++)
            if(hashMap.containsKey(i)==false)
            {
                res=i;
                break;
            }
        return res;
    }
}
