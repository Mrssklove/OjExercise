package Leetcode;

import Model.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> res=new ArrayList<>();
        if(intervals==null||intervals.size()==0)
            return res;
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start!=o2.start)
                    return o1.start-o2.start;
                else
                    return o1.end-o2.end;
            }
        });
        Interval temp=intervals.get(0);
        for(int i=1;i<intervals.size();i++)
        {
            Interval a=intervals.get(i);
            if(a.start>temp.end)
            {
                res.add(temp);
                temp=a;
            }
            else if(a.start<=temp.end&&a.end>=temp.end)
            {
                temp.end=a.end;
            }
        }
        res.add(temp);
        return res;
    }
}
