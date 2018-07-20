package Leetcode;

/**
 * 求次数
 * dp[i][j] 表示s的前i个字符 构成 t的前j个字符的次数
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int len1=s.length();
        int len2=t.length();
        int[][] dp=new int[len1+1][len2+1];

        for(int i=0;i<=len1;i++)
            dp[i][0]=1;
        for(int i=1;i<=len1;i++)
            for(int j=1;j<=len2;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        return dp[len1][len2];
    }
}