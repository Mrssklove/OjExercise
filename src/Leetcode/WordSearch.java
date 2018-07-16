package Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * dfs+剪枝
 */
public class WordSearch {
    static boolean isSuccess=false;
    public boolean exist(char[][] board, String word) {
        isSuccess=false;
        if(board==null&&board.length==0)
            return false;
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    boolean[][] visited=new boolean[row][col];
                    visited[i][j]=true;
                    if(dfsexist(board,i,j,row,col,word,1,word.length(),visited))
                        return true;
                }
            }
        return isSuccess;
    }

    public boolean dfsexist(char[][] board,int startx,int starty,int row,int col,String word,int curcount,int totalcount,boolean[][] visited){
        if(startx<0||startx>=row)
            return false;
        if(starty<0||starty>=col)
            return false;
        if(curcount==totalcount)
        {
            return true;
        }
        int[] dx=new int[]{1,-1,0,0};
        int[] dy=new int[]{0,0,1,-1};
        for(int i=0;i<4;i++)
        {
            int tempx=startx+dx[i];
            int tempy=starty+dy[i];
            if(tempx>=0&&tempx<row&&tempy>=0&&tempy<col&&visited[tempx][tempy]==false&&board[tempx][tempy]==word.charAt(curcount))
            {
                curcount++;
                visited[tempx][tempy]=true;
                boolean flag=dfsexist(board,tempx,tempy,row,col,word,curcount,totalcount,visited);
                if(flag)
                    return flag;
                visited[tempx][tempy]=false;
                curcount--;
            }
        }
        return false;
    }


}


