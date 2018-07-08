package Leetcode;

/**
 * 反正一个整数 包括符合
 * 注意：1.正负号
 * 2.高位零忽略
 * 3.溢出
 */
public class Leetcode7 {

    public int reverse(int x) {
       int MAX_V=Integer.MAX_VALUE;
       int MIN_V=Integer.MIN_VALUE;
       boolean isNegative=false;
       if(x<=0)   //标记正负数
       {
           x=-x;
           isNegative=true;
       }
       long res=0;
       while (x>=10)
       {
           int temp=x%10;
           x=x/10;
           res=res*10+temp;
       }
       res=res*10+x;
       if(isNegative)
           res=res*-1;
       if(res>MAX_V||res<MIN_V)
           return 0;
       else
           return (int) res;
    }
}
