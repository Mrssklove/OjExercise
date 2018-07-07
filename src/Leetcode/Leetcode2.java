package Leetcode;

import Model.ListNode;


/*
 Input:(2->4->3) + (5->6->4)
 Output:7->0->8

 243
 564

 708

 342
 465
    708
 链表反转 相加
 Tips:Integer.parseInt()会溢出
 应该使用模拟
 字符串的加减法
 字符串转链表

 */
public class Leetcode2 {

    public ListNode addTwoNumbers(ListNode l1,ListNode l2)
    {
       String a=reverseList(l1);
       String b=reverseList(l2);
       String c=Add(a,b);
       return  StringToListNode(c);

    }

    //以字符串的形式返回逆序
    public String reverseList(ListNode src)
    {
       if(src==null)
           return null;
       else
       {
           StringBuilder sb=new StringBuilder();
           while (src!=null)
           {
             sb.append(src.val);
             src=src.next;
           }
           return sb.toString();

       }
    }

    //大树模拟加法
    public String Add(String a,String b)
    {
        StringBuilder sb=new StringBuilder();
        int loop=a.length()>b.length()?a.length():b.length();
        int addflag=0;
        for(int i=0;i<loop;i++)
        {
            int avalue=0,bvalue=0;
            if(i+1<=a.length()) avalue=a.charAt(i)-'0';
            if(i+1<=b.length()) bvalue=b.charAt(i)-'0';
            int sum=avalue+bvalue+addflag;
            if(sum>=10)
            {
                sum-=10;
                addflag=1;
            }
            else
                addflag=0;
            sb.append(sum);
        }
        if(addflag==1)
            sb.append('1');
        return sb.reverse().toString();
    }

    //字符串转listNode
    public ListNode StringToListNode(String src)
    {
        if(src==null)
            return null;
        else {
            ListNode result=null;
            for(int i=0;i<src.length();i++)
            {
                ListNode temp=new ListNode(src.charAt(i)-'0');
                temp.next=result;
                result=temp;
            }
            return result;
        }
    }
}
