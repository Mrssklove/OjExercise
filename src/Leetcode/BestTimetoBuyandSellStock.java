package Leetcode;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
      if(prices==null||prices.length==0)
          return 0;
      int len=prices.length;
      int[] rightmax=new int[len];
      rightmax[len-1]=prices[len-1];
      for(int i=len-1;i>0;i--)
      {
          if(prices[i-1]>=rightmax[i])
              rightmax[i-1]=prices[i-1];
          else
              rightmax[i-1]=rightmax[i];
      }
      int res=0;
      for(int i=1;i<len;i++)
      {
          res=Math.max(res,rightmax[i]-prices[i-1]);
      }
      return res;
    }
}
