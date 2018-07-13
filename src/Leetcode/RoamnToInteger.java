package Leetcode;

import java.util.HashMap;

/**
 * 哈希+贪心，从首位开始取可能的最大值
 */
public class RoamnToInteger {
    public int romanToInt(String s) {
        HashMap<String,Integer> hashMap=new HashMap<>();
        initMap(hashMap);
        int res=0;
        int i=0,j=1;
        if(s.length()==1)
            return hashMap.get(s.substring(0,1));
        while (j<s.length())
        {

            if(hashMap.containsKey(s.substring(i,j))&&hashMap.containsKey(s.substring(i,j+1)))
            {
                j++;
            }
            else if(hashMap.containsKey(s.substring(i,j))&&hashMap.containsKey(s.substring(i,j+1))==false)
            {
                res+=hashMap.get(s.substring(i,j));
                i=j;
                j++;
            }
            if((j)==s.length()&&hashMap.containsKey(s.substring(i,j)))
            {
                res+=hashMap.get(s.substring(i,j));
                break;
            }
        }
        return res;
    }

    public void initMap(HashMap<String,Integer> hashMap)
    {
        hashMap.put("I",1);hashMap.put("II",2);hashMap.put("III",3);hashMap.put("IV",4);hashMap.put("V",5);
        hashMap.put("VI",6);hashMap.put("VII",7);hashMap.put("VIII",8);hashMap.put("IX",9);

        hashMap.put("X",10);hashMap.put("XX",20);hashMap.put("XXX",30);hashMap.put("XL",40);hashMap.put("L",50);
        hashMap.put("LX",60);hashMap.put("LXX",70);hashMap.put("LXXX",80);hashMap.put("XC",90);

        hashMap.put("C",100);hashMap.put("CC",200);hashMap.put("CCC",300);hashMap.put("CD",400);hashMap.put("D",500);
        hashMap.put("DC",600);hashMap.put("DCC",700);hashMap.put("DCCC",800);hashMap.put("CM",900);

        hashMap.put("M",1000);hashMap.put("MMM",2000);hashMap.put("MMM",3000);


    }
}
