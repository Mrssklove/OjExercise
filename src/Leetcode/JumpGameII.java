package Leetcode;

/**
 * DP
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int len=nums.length;
        int[] dp=new int[len];
        for(int i=1;i<len;++i)
            dp[i]=Integer.MAX_VALUE;
        for(int i=0;i<len;i++)
        {
            for(int j=1;j<=nums[i];++j)
            {
                if((i+j)<len)
                    dp[i+j]=Math.min(dp[i+j],dp[i]+1);
                else
                    break;
            }
        }
        return dp[len-1];
    }

}
