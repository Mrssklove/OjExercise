package 秋招2017;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

/**
 * Input "aab"
 * Output
 * [
 *   ["aa", "b"],
 *   ["a", "a", "b"]
 * ]
 * 暴力搜索
 */
public class 分割回文串 {
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        dfspartition(s,result,temp,0,s.length());

        return result;
    }

    public void dfspartition(String s,List<List<String>> result,List<String> temp,int start,int end)
    {
        int len=s.length();
        if(start>=len)
        {
            List<String> tt=new ArrayList<>(temp);
            result.add(tt);
            return ;
        }
        for(int i=start;i<len;i++)
        {
            if(isHuiWen(s.substring(start,i+1)))
            {
                List<String> tempList=new ArrayList<>();
                temp.add(s.substring(start,i+1));
                dfspartition(s,result,temp,i+1,end);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean isHuiWen(String src)
    {
        if(src==null)
            return false;
        for(int i=0;i<=src.length()/2;i++)
        {
            if(src.charAt(i)!=src.charAt(src.length()-1-i))
                return false;
        }
        return true;
    }
}
