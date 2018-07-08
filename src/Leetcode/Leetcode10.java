package Leetcode;

/**
 *    caaa
 *    c*a*
 *
 *    aab
 *    c*a*b
 * 是否是正则匹配
 * . 代表任何一个单字符
 * * 前一个字符可以出现任意次
 *  s:
 *  p:
 *  dp[i][j] 代表s的前i个字符 是否与p的前j个字符匹配
 *  if(s[i]==s[j]) dp[i][j]=dp[i-1][j-1]
 *  p中会出现 '.' ,'*'字符。
 *  if(p[i]=='.') 可以任意替换使之相等  dp[i][j]=dp[i-1][j-1]
 *  if(p[i]=='*")     *出现次数为任意次
 *      if(p[j-1]!=s[i]&&p[j-1]!='.')  即  xxa 与 xxc* 匹配的话   *必然是另次 否则直接为false  dp[i][j]=dp[i][j-2]
 *      else 当p[j-1]='.'时   如这种情况 xxa  (xxa.* xx.*)  此时*出现一次 并时p[j-1]=s[i]  dp[i][j]=dp[i][j-1]||dp[i][j-2]
 *           当p[j-1]==s[i]  xxcccc  xxc*   dp[i][j]=dp[i-1][j]  对应多次
 *
 */
public class Leetcode10 {
    public boolean isMatch(String s, String p) {
        int len1=s.length();
        int len2=p.length();
        boolean[][] dp=new boolean[len1+1][len2+1];
        dp[0][0]=true;
        for(int i=1;i<=len2;i++)            //0   b*c*a*
        {
            if(p.charAt(i-1)=='*'&&dp[0][i-2])
                dp[0][i]=true;
        }
        for(int i=1;i<=len1;i++)
            for(int j=1;j<=len2;j++)
            {
                if(s.charAt(i-1)==p.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else if(p.charAt(j-1)=='.')
                    dp[i][j]=dp[i-1][j-1];
                else if(p.charAt(j-1)=='*')
                {
                    if(j-2>=0&&p.charAt(j-2)!=s.charAt(i-1)&&p.charAt(j-2)!='.')
                        dp[i][j]=dp[i][j-2];
                    else
                        dp[i][j]=dp[i][j-1]||dp[i-1][j]||dp[i][j-2];
                }
            }
        return dp[len1][len2];
    }
}
