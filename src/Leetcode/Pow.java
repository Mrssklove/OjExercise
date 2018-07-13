package Leetcode;

/**
 * 1.注意最大负数取绝对值后会溢出 采取Long
 * 2.a^b=(a^2)(b/2)，-->logn次循环
 */
public class Pow {
    public double myPow(double x, int n) {
        long realn=n;
        if(realn==0) return 1;
        if(realn<0) {
            realn = -realn;
            x = 1/x;
        }
        double ans = 1;
        while(realn>0){
            if((realn&1)>0) ans *= x;
            x *= x;
            realn >>= 1;
        }
        return ans;
    }
}
