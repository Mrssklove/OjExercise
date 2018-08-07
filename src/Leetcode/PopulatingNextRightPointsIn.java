package Leetcode;

import Model.TreeLinkNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointsIn {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        Queue<TreeLinkNode> queue=new ArrayDeque<>();
        queue.add(root);
        List<List<TreeLinkNode>> nodelist=new ArrayList<>();
        while (!queue.isEmpty())
        {
            int size=queue.size();
            List<TreeLinkNode> temp=new ArrayList<>();
            while (size-->0)
            {
                TreeLinkNode node=queue.poll();
                temp.add(node);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            nodelist.add(temp);
        }

        //设置next指针
        int len=nodelist.size();
        for(int i=0;i<len;i++)
        {
            for(int j=0;j<nodelist.get(i).size()-1;++j)
            {
                TreeLinkNode a=nodelist.get(i).get(j);
                TreeLinkNode b=nodelist.get(i).get(j+1);
                a.next=b;

            }
        }
    }
}
