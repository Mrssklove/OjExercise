package Leetcode;

/**
 * 3种类型比较 O(n)时间
 * 1.2次遍历  桶排序
 * 2.维护3个索引，1个代表最后一个0的下标，1个代表最后一个1的下标，根据数字动态更新索引及值 One Pass
 * 3.维护首尾2个指针 i代表最后一个0的下标  j代表第一个2的下标
 */
public class SortColors {
    public void sortColors(int[] nums) {
      if(nums==null||nums.length==0)
          return;
      int len=nums.length;
      int zero=0,two=len-1;
      for(int i=0;i<len;++i)
      {
          if(nums[i]==0)
              swap(nums,i,zero++); //zero+1
          else if(nums[i]==2&&i<=two)
          {
              swap(nums,i,two--);
              i--;  //回退一步 重新比较换过来的值
          }
      }

    }

    void swap(int[] num,int i,int j)
    {
        int temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }
}
