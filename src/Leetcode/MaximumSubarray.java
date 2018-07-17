package Leetcode;

/**
 * 最大连续子数组 小于零重置零
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int currentSum=0;
        for(int i=0;i<nums.length;i++)
        {
            currentSum+=nums[i];
            maxSum=Math.max(currentSum,maxSum);
            if(currentSum<=0)
                currentSum=0;
        }
        return maxSum;
    }
}
