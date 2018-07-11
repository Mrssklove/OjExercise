package 秋招2017;

import java.util.*;

public class 第二大的数 {
    public int secondMax(int[] nums) {
        // write your code here
        Queue<Integer> list=new PriorityQueue<>(2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        list.add(nums[0]);
        list.add(nums[1]);
        for(int i=2;i<nums.length;i++)
        {
            list.add(nums[i]);
        }
        list.poll();
        return list.poll();
    }
}
