package 秋招2017;

import Model.ListNode;

/**
 * O(n)的时间复杂度
 */
public class 链表反转 {
    public ListNode reverse(ListNode head) {
        // write your code here
        if(head==null)
            return null;
        ListNode prev=null;
        ListNode now=head;
        ListNode next=now.next;

        while (now!=null)
        {
            next=now.next;
            now.next=prev;
            prev=now;
            now=next;
        }
        return prev;
    }
}
