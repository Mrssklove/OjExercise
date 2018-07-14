package Leetcode;

import java.util.Stack;

/**
 * Simply Path
 * ./
 * ../
 * .
 * //
 * stack记录当前位置
 */
public class SimplifyPaths {
    public String simplifyPath(String path) {
       String[] paths=path.split("/");
        Stack<String> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<paths.length;++i)
        {
            if(paths[i].equals("."))
                continue;
            else if(paths[i].equals(".."))
            {
                if(stack.isEmpty()==false)
                    stack.pop();
            }
            else if(paths[i].equals(""))
                continue;
            else
                stack.add(paths[i]);
        }
        Stack<String> temp=new Stack<>();
        while (stack.isEmpty()==false)
        {
            temp.add(stack.peek());
            stack.pop();
        }
        sb.append("/");
        while (temp.isEmpty()==false)
        {
            sb.append(temp.peek());
            sb.append("/");
            temp.pop();
        }
        if(sb.length()!=1)
        return sb.toString().substring(0,sb.length()-1);
        else
            return "/";
    }
}
