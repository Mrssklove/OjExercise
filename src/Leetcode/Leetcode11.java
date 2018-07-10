package Leetcode;

/**
 *
 * 矩形围成的最大面积
 * 暴力 O(n^2) 超时
 *
 * 首尾双指针逼近 有增大的可能
 *
 */
public class Leetcode11 {

    public int maxArea(int[] height) {

        int maxArea=0;
        int len=height.length;
        int start=0,end=len-1;
        maxArea=(end-start)*Math.min(height[start],height[end]);
        while (start<end)
        {
            while (height[end]>=height[start]&&start<end)
            {
                start++;
                maxArea=Math.max(maxArea,(end-start)*Math.min(height[start],height[end]));
            }
            while (height[end]<height[start]&&start<end)
            {
                end--;
                maxArea=Math.max(maxArea,(end-start)*Math.min(height[start],height[end]));
            }
        }
        return maxArea;
    }
}
