package Leetcode;


import java.util.HashMap;

/**
 * 2 Sum
 * Input[2,7,11,15]  target=9
 * Return indices [0,1]
 * 利用哈希表key=Input[indices]  value=indices
 */
public class Leetcode1 {
   public int[] twoSum(int[] nums,int target)
   {
       HashMap<Integer,Integer>  data=new HashMap<>();
       for(int i=0;i<nums.length;i++)
       {
           data.put(nums[i], i);
       }

       int[] result=new int[2];
       for(int i=0;i<nums.length;i++)
       {
           int t=target-nums[i];
           if(data.containsKey(t)&&data.get(t)!=i)
           {
               result[0]=i;
               result[1]=data.get(t);
               return result;
           }
       }
       return null;
   }
}
