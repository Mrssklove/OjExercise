package Leetcode;

/**
 * Z字型打印字符串  模拟
 * 根据行数确定有多少列
 * 标记isdown or isup
 */
public class Leetcode6 {

    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        int len=s.length();
        int maxCols=(len/(numRows+numRows-2)+1)*(numRows-1);
        char[][] data=new char[numRows][maxCols];
        int startx=0,starty=0;
        int index=0;
        boolean isDown=true,isUp=false;
        while (index<len)
        {
            if(isDown)
            {
                data[startx++][starty]=s.charAt(index);
                if(startx>=numRows) {
                    isDown=false;
                    isUp=true;
                    startx--;
                }
            }
            else if(isUp)
            {
                data[--startx][++starty]=s.charAt(index);
                if(startx==0) {
                    isDown=true;
                    isUp=false;
                    startx++;
                }
            }
            index++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<numRows;i++)
            for(int j=0;j<maxCols;j++)
                if(data[i][j]!='\000')   //默认填充为'\000' 而不是' '
                    sb.append(data[i][j]);
        return sb.toString();
    }

}
