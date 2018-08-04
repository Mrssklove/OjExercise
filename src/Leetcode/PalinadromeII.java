package Leetcode;

import java.util.Arrays;

public class PalinadromeII {
    public int minCut(String s) {
        int len=s.length();
        int[] dp=new int[len+1];
        Arrays.fill(dp,100000);
        dp[0]=0;
        for(int i=1;i<=len;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(isPalindrome(s.substring(j,i)))
                    dp[i]=Math.min(dp[i],dp[j]+1);
            }
            if(isPalindrome(s.substring(0,i)))
                dp[i]=0;
        }
        return dp[len];
    }


    boolean isPalindrome(String s)
    {
        boolean flag=true;
        int len=s.length();
        for (int i=0;i<=len/2;i++)
            if(s.charAt(i)!=s.charAt(len-1-i))
                return false;
        return true;
    }
}
