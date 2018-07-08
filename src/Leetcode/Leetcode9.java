package Leetcode;

public class Leetcode9 {
    public boolean isPalindrome(int x) {
       if(x<0)
           return false;
       int palindromeValue=0;
       int srcdata=x;
       while (x!=0)
       {
          int temp =x%10;
          x/=10;
          palindromeValue=palindromeValue*10+temp;
       }
       return palindromeValue==srcdata;
    }
}
