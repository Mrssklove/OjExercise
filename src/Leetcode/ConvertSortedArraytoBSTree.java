package Leetcode;

import Model.TreeNode;

import java.util.Arrays;

public class ConvertSortedArraytoBSTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0)
            return null;
        int len=nums.length;
        int midval=nums[len/2];
        TreeNode root=new TreeNode(midval);
        int[] left= Arrays.copyOfRange(nums,0,len/2);
        int[] right=Arrays.copyOfRange(nums,len/2+1,len);
        root.left=sortedArrayToBST(left);
        root.right=sortedArrayToBST(right);
        return root;
    }
}
