package Leetcode;
/*
从边缘搜索
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board==null||board.length==0)
            return;
        int row=board.length;
        int col=board[0].length;
        boolean[][] visited=new boolean[row][col];
        for(int i=0;i<row;i++)
            if(board[i][0]=='O'&&visited[i][0]==false)
                dfssolve(board,i,0,row,col,visited);
        for(int i=0;i<row;i++)
            if(board[i][col-1]=='O'&&visited[i][col-1]==false)
                dfssolve(board,i,col-1,row,col,visited);

        for(int j=0;j<col;j++)
            if(board[0][j]=='O'&&visited[0][j]==false)
                dfssolve(board,0,j,row,col,visited);


        for(int j=0;j<col;j++)
            if(board[row-1][j]=='O'&&visited[row-1][j]==false)
                dfssolve(board,row-1,j,row,col,visited);

        for(int i=1;i<row-1;i++)
            for(int j=1;j<col-1;j++)
                if(visited[i][j]==false)
                    board[i][j]='X';
    }

    public void dfssolve(char[][] board,int startx,int starty,int row,int col,boolean[][] visited)
    {
        if(startx<0||startx>=row||starty<0||starty>=col)
            return;
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};
        for(int i=0;i<4;i++)
        {
            int tempx=startx+dx[i];
            int tempy=starty+dy[i];
            if(tempx>=0&&tempx<row&&tempy>=0&&tempy<col&&visited[tempx][tempy]==false&&board[tempx][tempy]=='O')
            {
                visited[tempx][tempy]=true;
                dfssolve(board,tempx,tempy,row,col,visited);

            }
        }
    }
}
