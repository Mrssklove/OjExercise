package Leetcode;

/**
 * 从右上角搜索
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
      boolean result=false;
      if(matrix==null||matrix.length<=0)
            return false;
      int row=matrix.length;
      int col=matrix[0].length;
      int startx=0,starty=col-1;
      while (startx<row&&starty>=0)
      {
          if(target==matrix[startx][starty])
              return true;
          else if(target>matrix[startx][starty])
              startx++;
          else
              starty--;
      }
      return result;
    }
}
