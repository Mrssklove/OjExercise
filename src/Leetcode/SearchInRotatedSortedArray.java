package Leetcode;

/**
 * 旋转数组 二分查找
 * 1.根据mid值与target比较  需要判断几种情况
 * 2.根据mid值与num[start] num[end]比较，即可得出落点，判断情况减少。
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return -1;
        int start=0;
        int end=nums.length-1;
        while (start<=end)
        {
            int mid=(start+end)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>target)  //中点比目标值大  可能出现在左半边
            {
              if(nums[mid]<nums[start])
                  end=mid-1;
              else if(nums[mid]>=nums[start]&&nums[start]<=target)
                  end=mid-1;
              else
                  start=mid+1;
            }
            else if(nums[mid]<target) //中点比目标值小 大的值可能出现在右边和左边
            {
                if(nums[mid]>=nums[end])
                    start=mid+1;
                else if(nums[end]>=target)
                    start=mid+1;
                else
                    end=mid-1;
            }
        }
        return -1;
    }
}
