package Leetcode;

/**
 * 有更优解 贪心 每次更新可最远到达距离
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int len=nums.length;
        boolean[] dp=new boolean[len];
        if(nums==null||nums.length==0)
            return false;
        if(nums[0]==0)
        {
            if(len==1) return true;
            else return false;
        }
        dp[0]=true;
        for(int i=0;i<len;i++)
            for(int j=0;j<=nums[i];j++)
            {
                if(i+j<len&&dp[i]==true)
                    dp[i+j]=true;
            }

        return dp[len-1];
    }
}
