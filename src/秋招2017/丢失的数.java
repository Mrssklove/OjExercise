package 秋招2017;

/**
 * 求和递减
 */
public class 丢失的数 {

    public int findMissing(int[] nums) {
        // write your code here
        int len=nums.length+1;
        int max=(0+len-1)*(len)/2;
        for(int i=0;i<len-1;i++)
            max-=nums[i];
        return max;
    }
}
