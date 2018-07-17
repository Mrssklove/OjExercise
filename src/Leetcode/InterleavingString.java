package Leetcode;

/**
 * DP
 * dp[i][j] 表示s1前i个字符与s2前j个字符 是否可以构造s3前(i+j)个字符
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int lens1=s1.length();
        int lens2=s2.length();
        int lens3=s3.length();
        boolean[][] dp=new boolean[lens1+1][lens2+1];
        if(lens1+lens2!=s3.length())
            return false;

        for(int i=1;i<=lens1;i++)
            dp[i][0]=s3.substring(0,i).equals(s1.substring(0,i));
        for(int i=1;i<=lens2;i++)
            dp[0][i]=s3.substring(0,i).equals(s2.substring(0,i));
        dp[0][0]=true;
        for(int i=1;i<=lens1;i++)
            for(int j=1;j<=lens2;j++)
            {
                boolean temp1=false,temp2=false;
                if(i-1>=0&&s3.charAt(i+j-1)==s1.charAt(i-1)&&dp[i-1][j])
                    temp1=true;
                if(j-1>=0&&s3.charAt(i+j-1)==s2.charAt(j-1)&&dp[i][j-1])
                    temp2=true;
                dp[i][j]=temp1||temp2;
            }
        return dp[lens1][lens2];
    }
}
