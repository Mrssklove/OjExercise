package Leetcode;

/**
 * 大数乘法
 * 逐位相乘处理进位法
 * 45*65
 * （5,4）*（5,6）=（25，50，24）=（5,52,24）=（5,2,29）=（5,2,9,2）=（5,2,9,2）=2925
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        StringBuilder a=new StringBuilder(num1);
        StringBuilder b=new StringBuilder(num2);
        a.reverse();
        b.reverse();
        int[] result=new int[num1.length()+num2.length()];
        int i,j;
        for(i=0;i<a.length();i++) {
            int temp=0;
            for (j = 0; j < b.length(); j++) {
                temp = result[i + j] + (a.charAt(i) - '0') * (b.charAt(j) - '0');
                result[i + j] = temp % 10;
                temp /= 10;
                if (temp != 0)  //进位
                {
                    result[i + j + 1] += temp;
                    temp /= 10;
                }
            }
        }
        StringBuilder sb=new StringBuilder(); //
        boolean isAdd=false;
        for(int p=result.length-1;p>=0;p--)
        {
            if(result[p]!=0)
                isAdd=true;
            if(isAdd)
                sb.append(result[p]);
        }
        if(sb.toString().length()==0)
            return "0";
        return sb.toString();
    }
}
