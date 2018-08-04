package Leetcode;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len=s.length();
        boolean[] dp=new boolean[len+1];
        dp[0]=true;
        for(int i=1;i<=len;i++)
        {
            for(int j=0;j<=i;++j)
            {
                dp[i]=dp[j]&&wordDict.contains(s.substring(j,i));
                if(dp[i])
                    break;
            }
        }
        return dp[len];
    }
}
