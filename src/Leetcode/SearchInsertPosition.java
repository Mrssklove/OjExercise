package Leetcode;

/**
 * 二分查找
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return 0;
        int length=nums.length;
        int start=0,end=length-1;
        int mid=0;
        while (start<=end)
        {
            mid=(start+end)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        if(nums[mid]>target)
            return mid;
        return mid+1;

    }
}
