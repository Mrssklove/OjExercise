package 秋招2017;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Top->堆-->优先级队列--比较器(策略模式)
 */
public class TopK {
    public String[] topKFrequentWords(String[] words, int k) {
        // write your code here
        HashMap<String,Integer> frequency=new HashMap<>();
        for(int i=0;i<words.length;i++)
        {
            if(frequency.containsKey(words[i])==false)
                frequency.put(words[i],1);
            else
                frequency.put(words[i],frequency.get(words[i])+1);
        }
        PriorityQueue<SortObject> queue=new PriorityQueue<>(new Comparator<SortObject>() {
            @Override
            public int compare(SortObject o1, SortObject o2) {
                if(o1.count>o2.count)
                    return -1;
                else if(o1.count<o2.count)
                    return 1;
                else if(o1.count==o2.count&&o1.data.compareTo(o2.data)<0)
                    return -1;
                else if(o1.count==o2.count&&o1.data.compareTo(o2.data)>0)
                    return 1;
                else if(o1.count==o2.count&&o1.data.compareTo(o2.data)==0)
                    return 0;
                return 0;
            }
        });
        for(Map.Entry<String ,Integer> entry:frequency.entrySet())
        {
            queue.add(new SortObject(entry.getKey(),entry.getValue()));
        }

        //find top k
        String[] res=new String[k];
        int index=0;
        while (--k>=0)
        {
            res[index++]=queue.poll().data;
        }
        return res;
    }

    static class SortObject{
        public String data;
        public int count;
        public SortObject(String d,int c)
        {
            data=d;count=c;
        }
    }
}
