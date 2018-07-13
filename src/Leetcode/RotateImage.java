package Leetcode;

/**
 * 先对角线旋转，然后上下翻转，
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if(matrix==null)
            return;
        int row=matrix.length;
        for(int i=0;i<row;++i)
            for(int j=0;j<row-i;++j)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[row-1-j][row-1-i];
                matrix[row-1-j][row-1-i]=temp;
            }
        //上下对称翻转
        for(int i=0;i<row/2;i++)
        {
            for(int j=0;j<row;++j)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[row-1-i][j];
                matrix[row-1-i][j]=temp;
            }
        }
    }
}
