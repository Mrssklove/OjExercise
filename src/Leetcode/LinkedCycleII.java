package Leetcode;

import Model.ListNode;

public class LinkedCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode slow=head;
        ListNode fast=head;
        boolean isCycle=false;
        while (slow!=null&&fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                isCycle=true;
                break;
            }
        }

        if(!isCycle)
            return null;
        else   //
        {
            ListNode startA=head;
            ListNode startB=slow;
            while (startA!=startB)
            {
                startA=startA.next;
                startB=startB.next;
            }
            return startA;
        }
    }
}
