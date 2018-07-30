package Leetcode;

import Model.Point;

import java.util.HashMap;

/*
  1.斜率不存在的情况
  2.重合的点
  3.斜率的表示（直接y/x 存在精度不准确 采取求最大公约数）
 */
public class MaxPointsOnLine {
    public int maxPoints(Point[] points) {
      int len=points.length;
      int res=0;
      for(int i=0;i<len;i++)
      {
          int samepointcount=0;
          int max=0;
          HashMap<Integer,HashMap<Integer,Integer>> hashMap=new HashMap<>(); // x y   y/x count
          for(int j=0;j<len;j++)
          {
              if(j!=i)
              {
                  int x=points[j].x-points[i].x;
                  int y=points[j].y-points[i].y;
                  if(x==0&&y==0) {
                      samepointcount++;
                      continue;
                  }
                  int maxgcd=GCD(x,y);
                  if(maxgcd!=0)
                  {
                      x/=maxgcd;
                      y/=maxgcd;
                  }
                  if(hashMap.containsKey(x)==false)
                  {
                     HashMap<Integer,Integer> map=new HashMap<>();
                     map.put(y,1);
                     hashMap.put(x,map);
                  }
                  else {
                    if(hashMap.get(x).containsKey(y)){
                        hashMap.get(x).put(y,hashMap.get(x).get(y)+1);
                    }else {
                        hashMap.get(x).put(y,1);
                    }
                  }
                  max=Math.max(max,hashMap.get(x).get(y));
              }
          }
          res=Math.max(res,max+samepointcount+1);
      }
      return res;
    }

    public int GCD(int a,int b)
    {
        if(b==0) return a;
        return GCD(b,a%b);
    }
}
