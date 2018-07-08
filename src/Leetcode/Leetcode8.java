package Leetcode;

/**
 * 字符串转数字
 * 1、去除无用的空格
 * 2.第一个数字
 * 3.溢出  break 溢出与符号结合后 在判断是否溢出
 * 4.小数点
 */
public class Leetcode8 {
    public int myAtoi(String str) {

        StringBuilder sb=new StringBuilder(str.trim());
        String[] datas=sb.toString().split("\\s++"); //一个空格or多个空格隔开
        String target=datas[0];
        if(target.length()<1) return 0;
        boolean isNegative=false;
        long res=0;
        if(target.charAt(0)=='-') isNegative=true;
       else if(target.charAt(0)=='+') isNegative=false;
       else if(target.charAt(0)<'0'||target.charAt(0)>'9')
            return 0;
       else
            res=res*10+target.charAt(0)-'0';
        for(int i=1;i<target.length();i++)
        {

            {
                if(target.charAt(i)=='.')
                    break;
                if(target.charAt(i)<'0'||target.charAt(i)>'9')
                    break;
                else
                {
                    res=res*10+target.charAt(i)-'0';
                    if(res>(Integer.MAX_VALUE))
                    {
                        break;
                    }
                }
            }
        }
        if(isNegative)
            res=res*-1;
        if(res>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(res<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int) res;


    }
}
