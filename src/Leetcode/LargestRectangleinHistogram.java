package Leetcode;

/**
 * 1.常规 O(n^2) 选一点从两边延伸  313ms
 * 2.栈 O(n)
 * 3.递归 nlogn
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
       if(heights==null||heights.length==0)
           return 0;
       int len=heights.length;
       int maxArea=0;
       for(int i=0;i<len;i++)
       {
           int left=i;
           int right=i;
           while (left>0&&heights[left-1]>=heights[i]) left--;
           while (right<len-1&&heights[right+1]>=heights[i]) right++;
           maxArea=Math.max(maxArea,(right-left+1)*heights[i]);
       }
       return maxArea;
    }
}
