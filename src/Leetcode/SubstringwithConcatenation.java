package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode30
 * 对字符串哈希
 */
public class SubstringwithConcatenation {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        List<String> wordlist=new ArrayList<>();
        if(words==null||s.length()==0||words.length==0)
            return res;
        int len=words[0].length();
        for(int i=0;i<words.length;i++)
        {
            if(words[i].length()!=len)
                return res;
            wordlist.add(words[i]);
        }

        int totallength=len*words.length;
        if(totallength>s.length()) return res;
        for(int i=0;i<=s.length()-totallength;i++)
        {
            List<String> templist=new ArrayList<>();
            templist.addAll(wordlist);
            if(IsMatch(s.substring(i,totallength+i),templist))
                res.add(i);
        }
        return res;
    }

    public boolean IsMatch(String s,List<String> words)
    {
        int len=words.get(0).length();
        for(int i=0;i<=s.length()-len;i=i+len)
        {
            String temp=s.substring(i,i+len);
            if( words.remove(temp)==false) return false;
        }
        return words.isEmpty();
    }
}
