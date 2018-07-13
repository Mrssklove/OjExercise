package Leetcode;

/**
 * 打表 预设所有可能情况 直接取
 */
public class IntergerToRoman {
    public String intToRoman(int num) {
        String[] first=new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] second=new String[]{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] third=new String[]{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] fourth=new String[]{"","M","MM","MMM"};
        String s=String.valueOf(num);
        StringBuilder sb=new StringBuilder();
        int len=s.length();
        int index=len;
        for(int i=0;i<len;i++)
        {
            int temp=s.charAt(i)-'0';
            if(index==4)
                sb.append(fourth[temp]);
            else if(index==3)
                sb.append(third[temp]);
            else if(index==2)
                sb.append(second[temp]);
            else if(index==1)
                sb.append(first[temp]);
            index--;
        }
        return sb.toString();

    }
}
