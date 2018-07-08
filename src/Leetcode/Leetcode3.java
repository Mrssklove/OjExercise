package Leetcode;

import java.util.HashMap;

/** 最长连续非重复子串
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 采用局部更新Hashmap
 */
public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hashMap=new HashMap<>();
        if(s.length()<1)
            return 0;
        int max=0;
        int startindex=0;
        for(int i=0;i<s.length();i++)
        {
            if(hashMap.containsKey(s.charAt(i))==false||hashMap.get(s.charAt(i))<startindex)  //<startindex很重要 如abba 此时ab ba
            {
                hashMap.put(s.charAt(i),i);
                max=Math.max(max,i-startindex+1);
            }
            else
            {
                int repeatindex=hashMap.get(s.charAt(i));
                hashMap.put(s.charAt(i),i);//更新
                startindex=repeatindex+1;
                max=Math.max(max,i-startindex+1);
            }
        }
        return max;
    }
}
