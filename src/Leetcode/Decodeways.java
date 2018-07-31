package Leetcode;

public class Decodeways {
    public int numDecodings(String s) {
        if(s==null||s.length()==0)
            return 0;
        if(s.charAt(0)=='0')
            return 0;
        int len=s.length();
        int[] dp=new int[len+1];
        dp[1]=1;
        dp[0]=1;
        for(int i=2;i<=len;i++)
        {
            int v=Integer.valueOf(s.substring(i-1,i));
            int vv=Integer.valueOf(s.substring(i-2,i));
            if(v>=1&&v<=9)
                dp[i]+=dp[i-1];
            if(vv>=10&&vv<=26)
                dp[i]+=dp[i-2];
        }
        return dp[len];
    }
}
