package Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {


        if(nums==null||nums.length==0||k>nums.length)
            return 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<nums.length;i++)
            pq.add(nums[i]);
        int res=0;
        while (k-->0)
        {
            res=pq.poll();
        }
        return res;
    }
}
