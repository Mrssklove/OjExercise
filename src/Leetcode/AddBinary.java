package Leetcode;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res=new StringBuilder();
        int lena=a.length();
        int lenb=b.length();
        StringBuilder aa=new StringBuilder(a);aa=aa.reverse();
        StringBuilder bb=new StringBuilder(b);bb=bb.reverse();
        int max=Math.max(lena,lenb);
        int isUp=0;
        for(int i=0;i<max;i++)
        {
            if(i<lena&&i<lenb)
            {
                int temp=aa.charAt(i)-'0'+bb.charAt(i)-'0'+isUp;
                if(temp>=2)
                {
                    isUp=1;
                    res.append(temp-2);
                }
                else
                {
                    isUp=0;
                    res.append(temp);
                }
            }
            else if(i<lena&&i>=lenb)
            {
                int temp=aa.charAt(i)-'0'+isUp;
                if(temp>=2)
                {
                    isUp=1;
                    res.append(temp-2);
                }
                else
                {
                    isUp=0;
                    res.append(temp);
                }
            }
            else if(i>=lena&&i<lenb)
            {
                int temp=bb.charAt(i)-'0'+isUp;
                if(temp>=2)
                {
                    isUp=1;
                    res.append(temp-2);
                }
                else
                {
                    isUp=0;
                    res.append(temp);
                }
            }
        }

        if(isUp==1)
            res.append(1);
        return res.reverse().toString();
    }
}
