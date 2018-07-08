package Leetcode;

/**
 * 最短编辑距离
 * 1.先判断是不是该用动态规划解
 * 若是求所有的方案和结果  则肯定不是
 * 若是求最大/最小  方案总数  则很可能是动态规划 因为不需要保存中间的状态
 * 该题是求最短距离  不需要求最短距离的具体路径 所有很大概率是动态规划。下面来找状态转移方程
 * 1. 状态是什么
 * 2. 状态转移方程是什么
 * 3. 状态的初始值是什么
 * 4. 问题要求的最后答案是什么
 */

/*
  每次操作可增加  减少 更改
  word1:horse
  word2:ros

  horse
    ros

  状态可表示成dp[i][j]  表示word1的前i个字符   转换到word2的前j个字符需要的次数
  dp[i][j]={
                  dp[i-1][j-1]  if word1[i]==word2[j]
                  不相等 则考虑3种情况
                  1.更改 则dp[i-][j-1]+1
                  2.删除 dp[i-1][j]+1
                  3.增加 dp[i][j-1]+1

      滚动二维数组 初始状态为dp[0][j]=j  dp[i][0]=i
 */
public class Leetcode72 {
    public int minDistance(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int[][] dp=new int[len1+1][len2+1];


        for(int i=0;i<=len2;i++) dp[0][i]=i;
        for(int i=0;i<=len1;i++) dp[i][0]=i;

        for(int i=1;i<=len1;i++)
            for(int j=1;j<=len2;j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                {
                    dp[i][j]=Math.min(Math.min(dp[i][j-1]+1,dp[i-1][j]+1),dp[i-1][j-1]+1);
                }
            }
         return dp[len1][len2];
    }
}
