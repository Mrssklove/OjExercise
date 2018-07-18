package Leetcode;

import Model.ListNode;

/**
 * 2个指针 然后合并
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head==null)
            return null;
        ListNode start=null,end=null,startofstart=null,endofstart=null;
        while (head!=null)
        {
            int val=head.val;
            if(val<x)
            {
                ListNode temp=new ListNode(val);
                if(start==null)
                {
                    start=temp;
                    startofstart=start;
                }
                else
                {
                    start.next=temp;
                    start=temp;
                }
            }
            else if(val>=x)
            {
                ListNode temp=new ListNode(val);
                if(end==null)
                {
                    end=temp;
                    endofstart=end;
                }
                else
                {
                    end.next=temp;
                    end=temp;
                }
            }
            head=head.next;
        }
        if(startofstart==null)
            return endofstart;
        start.next=endofstart;
        return startofstart;
    }
}
