package Leetcode;

import java.util.Stack;

/**
 * 左括号进栈
 * 右括号分3种情况 1.栈为空，而当前又是右括号，则当前右括号无效，重置有效长度初始值
 *                2.栈不空，则弹出左括号，弹出之后栈为空，则存在一个可能的有效值等于当前位置-start
 *                3.栈不空，则弹出左括号，弹出之后栈为空，则存在一个可能的有效值等于当前位置-栈顶位置索引
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        int start=-1;
        int maxlen=0;

        for(int i=0;i<s.length();++i)
        {
            char temp=s.charAt(i);
            if(temp=='(')
                stack.add(i);
            else
            {
                if(stack.isEmpty())   //重新开始计算
                    start=i;
                else if(stack.isEmpty()==false)
                {
                    stack.pop();
                    if(stack.isEmpty())
                        maxlen=Math.max(maxlen,i-start);
                    else
                    {
                        int stacktopindex=stack.peek();
                        maxlen=Math.max(maxlen,i-stacktopindex);
                    }
                }
            }
        }
        return maxlen;
    }
}
