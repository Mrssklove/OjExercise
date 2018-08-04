package Leetcode;

import java.util.Stack;

/*
暴力 o(n^3)
单调栈
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0)
            return 0;
        int row=matrix.length;
        int col=matrix[0].length;
        int[] height=new int[col+1];
        int res=0;
        for(int i=0;i<row;i++)
        {    for(int j=0;j<col;j++)
        {
            if(matrix[i][j]=='0')
                height[j]=0;
            else
                ++height[j];
        }
            res=Math.max(res,maxAreaHeight(height));
        }
        return res;
    }

    public int maxAreaHeight(int[] height)
    {
        int maxarea=0;
        int len=height.length;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<len;i++)
        {
            while (stack.isEmpty()==false&&height[i]<height[stack.peek()])
            {
                int temph=height[stack.peek()]; //以height[i]为高 左边界
                stack.pop();
                int width=0;
                if(stack.isEmpty())
                    width=-1;
                else
                    width=stack.peek();
                maxarea=Math.max(maxarea,temph*(i-width-1));
            }
            stack.add(i);
        }
        return maxarea;
    }
}
