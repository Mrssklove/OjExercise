package Leetcode;

public class Numbersofislands {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        int row=grid.length;
        int col=grid[0].length;
        boolean[][] visited=new boolean[row][col];
        int count=0;
        for(int i=0;i<row;++i)
            for(int j=0;j<col;++j)
            {
                if(grid[i][j]=='1'&&visited[i][j]==false)
                {
                    count++;
                    helpdfs(visited,grid,i,j,row,col);
                }
            }
        return count;
    }


    public void helpdfs(boolean[][] visited,char[][] grid,int x,int y,int row,int col)
    {
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};
        if(x<0||x>row||y<0||y>col)
            return;
        visited[x][y]=true;
        for(int i=0;i<4;i++)
        {
            int tempx=x+dx[i];
            int tempy=y+dy[i];
            if(tempx>=0&&tempx<row&&tempy>=0&&tempy<col&&visited[tempx][tempy]==false&&grid[tempx][tempy]=='1')
            {
                helpdfs(visited,grid,tempx,tempy,row,col);
            }
        }
    }
}
