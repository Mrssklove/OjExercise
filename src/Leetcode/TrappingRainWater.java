package Leetcode;

/**
 * Leetcode42 维护2个最左最右数组 O(n)
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int maxWater=0;
        if(height==null||height.length<3)
            return 0;
        int len=height.length;
        int[] leftmax=new int[len];
        int[] rightmax=new int[len];
        int templeftmax=height[0];
        for(int i=0;i<len;i++)
        {
            if(height[i]>templeftmax)
            {
                leftmax[i]=height[i];
                templeftmax=height[i];
            }
            else
                leftmax[i]=templeftmax;
        }
        int temprightmax=height[len-1];
        for(int i=len-1;i>=0;i--)
        {
            if(height[i]>temprightmax)
            {
                rightmax[i]=height[i];
                temprightmax=height[i];
            }else
                rightmax[i]=temprightmax;
        }
        //能盛水区域位于[1,len-2]
        for(int i=1;i<=len-2;i++)
        {
            int left=leftmax[i-1];
            int right=rightmax[i+1];
            int min=Math.min(left,right);
            if(min>height[i])
                maxWater+=min-height[i];
        }
        return maxWater;
    }
}
