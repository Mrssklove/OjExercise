package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Set
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums)
            set.add(num);
        int res=0;
        for(int num:nums)
        {
            int count=1;
            int temp=num;
            while (set.contains(temp-1))
            {
                count++;
                set.remove(temp);
                temp--;
            }
            temp=num;
            while (set.contains(temp+1))
            {
                count++;
                set.remove(temp);
                temp++;
            }
            res=Math.max(res,count);
        }
        return res;
    }
}
