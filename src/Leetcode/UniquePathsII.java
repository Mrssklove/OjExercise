package Leetcode;

/**
 * Dp 不可达置为0
 * 初始条件的设置 前面均为0则等于1 1后面的均为0
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       int row=obstacleGrid.length;
       int col=obstacleGrid[0].length;
       int[][] dp=new int[row][col];
       int startrow=0,startcol=0;
       for(;startrow<row&&obstacleGrid[startrow][0]==0;++startrow)
           dp[startrow][0]=1;
       for(;startrow<row;++startrow)
           dp[startrow][0]=0;
       for(startcol=0;startcol<col&&obstacleGrid[0][startcol]==0;++startcol)
           dp[0][startcol]=1;
       for(;startcol<col;++startcol)
           dp[0][startcol]=0;
       for(int i=0;i<row;++i)
           for(int j=0;j<col;++j)
               if(obstacleGrid[i][j]==1)
                   dp[i][j]=0;
       for(int i=1;i<row;++i)
           for(int j=1;j<col;++j)
           {
               if(obstacleGrid[i][j]==0)
               dp[i][j]=dp[i-1][j]+dp[i][j-1];
           }
       return dp[row-1][col-1];
    }
}
