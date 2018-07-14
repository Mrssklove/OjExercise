package Leetcode;

/**
 * O(m+n) 先记录第一行与第一列的数据 从i=1 j=1开始遍历 记录标致为第一行和第一列
 * 0(1) 因为第一行 第一列 要么全为零 要么不变 单独设2个标记即可
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
       boolean isFirstRowZero=false;
       boolean isFirstColZero=false;
       if(matrix==null)
           return;
       int row=matrix.length;
       int col=matrix[0].length;
       for(int i=0;i<row;++i)
           if(matrix[i][0]==0)
               isFirstRowZero=true;
       for(int i=0;i<col;++i)
           if(matrix[0][i]==0)
               isFirstColZero=true;
       for(int i=1;i<row;++i)
           for(int j=1;j<col;++j)
           {
               if(matrix[i][j]==0)
               {
                   matrix[i][0]=0;
                   matrix[0][j]=0;
               }
           }
       //根据标记位
       for(int i=1;i<row;++i)
           for(int j=1;j<col;++j)
           {
               if(matrix[i][0]==0||matrix[0][j]==0)
                   matrix[i][j]=0;
           }
        if(isFirstColZero)
        {
            for(int i=0;i<col;++i)
                matrix[0][i]=0;
        }
        if(isFirstRowZero)
        {
            for(int i=0;i<row;++i)
                matrix[i][0]=0;
        }
    }
}
