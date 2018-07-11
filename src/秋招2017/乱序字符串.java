package 秋招2017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 乱序 --字符出现次数相同 --<K,V>
 */
public class 乱序字符串 {
    public List<String> anagrams(String[] strs) {
        // write your code here
        HashMap<HashMap<Character,Integer>,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;++i)
        {
            HashMap<Character,Integer> key=new HashMap<>();
            for(int j=0;j<strs[i].length();++j)
            {
                Character temp=strs[i].charAt(j);
                if(key.containsKey(temp)==false)
                    key.put(temp,1);
                else
                    key.put(temp,key.get(temp)+1);
            }
            if(map.containsKey(key)==false)
            {  List<String> t=new ArrayList<>();
                t.add(strs[i]);
                map.put(key,t);}
            else
            {
                map.get(key).add(strs[i]);
                map.put(key,map.get(key));
            }
        }
        List<String> res=new ArrayList<>();
        for(Map.Entry<HashMap<Character,Integer>,List<String>> entry:map.entrySet())
        {
            if(entry.getValue().size()>=2)
                res.addAll(entry.getValue());
        }
        return res;
    }
}
