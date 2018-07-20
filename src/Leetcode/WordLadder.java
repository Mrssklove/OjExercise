package Leetcode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * BFS
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(new Node(beginWord,1));
        boolean isFind=false;
        int res=0;
        boolean[] visited=new boolean[wordList.size()];
        while (!queue.isEmpty())
        {
            Node  temp=((ArrayDeque<Node>) queue).pop();
            if(temp.s.equals(endWord))
            {
                res=temp.step;
                break;
            }
            for(int i=0;i<wordList.size();i++)
            {
                if(visited[i]==false&&isCanExchange(temp.s,wordList.get(i)))
                {
                    visited[i]=true;
                    queue.add(new Node(wordList.get(i),temp.step+1));
                }
            }

        }
        return res;
    }

    private boolean isCanExchange(String src,String tar)
    {
        int discount=0;
        if(src.length()!=tar.length())
            return false;
        for(int i=0;i<src.length();i++)
        {
            if(src.charAt(i)!=tar.charAt(i))
                discount++;
            if(discount>1)
                return false;
        }
        return true;

    }

    static class Node{
        String s;
        int step;
        Node(String s,int step)
        {
            this.s=s;
            this.step=step;
        }
    }
}
