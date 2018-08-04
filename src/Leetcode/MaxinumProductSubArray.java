package Leetcode;

public class MaxinumProductSubArray {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        int len=nums.length;
        int[] dpmax=new int[len+1];
        int[] dpmin=new int[len+1];
        dpmax[0]=dpmin[0]=1;
        int res=Integer.MIN_VALUE;
        for(int i=1;i<=len;i++)
        {
            if(nums[i-1]>0)
            {
                dpmax[i]=Math.max(dpmax[i-1]*nums[i-1],nums[i-1]);
                dpmin[i]=Math.min(dpmin[i-1]*nums[i-1],nums[i-1]);
            }
            else if(nums[i-1]<0)
            {
                dpmax[i]=Math.max(dpmin[i-1]*nums[i-1],nums[i-1]);
                dpmin[i]=Math.min(dpmax[i-1]*nums[i-1],nums[i-1]);
            }
            else if(nums[i-1]==0)
            {
                dpmax[i]=dpmin[i]=0;
            }
            res=Math.max(res,dpmax[i]);
        }
        return res;
    }
}
