package Leetcode;

import java.util.HashMap;

/**最小子串覆盖
 * O(n)
 * 滑动窗口的思想 不断缩小窗口 注意重复的  存在负数
 */
public class MinimumWindowSubString {
    public String minWindow(String s, String t) {
       int len=t.length();
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for(int i=0;i<len;++i)
        {
            char temp=t.charAt(i);
            if(hashMap.containsKey(temp)==false)
                hashMap.put(temp,1);
            else
                hashMap.put(temp,hashMap.get(temp)+1);
        }
        int count=len,start=0;
        String res="";
        for(int i=0;i<s.length();++i)
        {
            char temp=s.charAt(i);
            if(hashMap.containsKey(temp))  //找到一个
            {
                hashMap.put(temp,hashMap.get(temp)-1);
                if(hashMap.get(temp)>=0)
                count--;
            }
            while (count==0)  //已找到全部 缩小窗口
            {
                if(res.equals(""))
                    res=s.substring(start,i+1);
                else
                {
                    if((i-start+1)<res.length())
                        res=s.substring(start,i+1);
                }
                //
                char tt=s.charAt(start); //从start开始尝试缩小窗口
                if(hashMap.containsKey(tt))
                {
                    hashMap.put(tt,hashMap.get(tt)+1);
                    if(hashMap.get(tt)>0)
                        count++;
                }
                start++;
            }
        }
        return res;
    }
}
