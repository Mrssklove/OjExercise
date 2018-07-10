package 秋招2017;

import java.util.List;

/**
 * +-+-统计
 */
public class 主元素 {
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        if(nums.size()==1)
            return nums.get(0);
        int res=nums.get(0);
        int count=1;
        for(int i=1;i<nums.size();++i)
        {
            if(nums.get(i)==res)
            {
                count++;
            }else if(nums.get(i)!=res)
            {
               count--;
               if(count<=0)
               {
                   count=1;
                   res=nums.get(i);
               }
            }
        }
        return res;
    }
}
