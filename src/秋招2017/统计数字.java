package 秋招2017;

public class 统计数字 {
    public int digitCounts(int k, int n) {
        // write your code here
        int count=0;
        for(int i=0;i<=n;i++)
        {
            StringBuilder sb=new StringBuilder();
            sb.append(Integer.toString(i));
            for(int j=0;j<sb.toString().length();j++)
                if(sb.toString().charAt(j)-'0'==k)
                    count++;
        }


        return count;
    }
}
