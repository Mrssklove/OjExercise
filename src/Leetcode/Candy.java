package Leetcode;

/**
 * 左右扫描
 */
public class Candy {
    public int candy(int[] ratings) {
        int res=0;
        int len=ratings.length;
        int[] candys=new int[len];
        for(int i=0;i<len;i++)
            candys[i]=1;
        //从左开始扫描
        for(int i=1;i<len;i++)
            if(ratings[i]>ratings[i-1])
                candys[i]=candys[i-1]+1;
        //从右扫描
        for(int j=len-1;j>0;j--)
            if(ratings[j-1]>ratings[j])
                candys[j-1]=Math.max(candys[j-1],candys[j]+1);
        for(int i=0;i<len;i++)
            res+=candys[i];
        return res;
    }
}
