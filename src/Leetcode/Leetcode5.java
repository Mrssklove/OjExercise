package Leetcode;

/**
 * 最长回文子串
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 dp


 dp[i][j]={
         true,   i=j, 字符串本身就是回文
         false   i!=j
         s[i]=s[j]&&(j-i<3||dp[i+1][j-1]))

   i----> i+1
   j----->j-1
 }
 **/
public class Leetcode5 {
    public String longestPalindrome(String s) {
       String res="";
       int len=s.length();
       boolean[][] dp=new boolean[len][len];
       for(int i=len-1;i>=0;i--)   //i------> i+1
           for(int j=i;j<len;j++)
           {
               if(i==j)  { dp[i][j]=true;}
               else if(i!=j)
               {
                  if(s.charAt(i)==s.charAt(j)&&j-i<3) dp[i][j]=true;
                  else if(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]) dp[i][j]=true;
               }
               if(dp[i][j]==true)
                   if((j-i+1)>=res.length())
                       res=s.substring(i,j+1);
           }
       return res;
    }
}
