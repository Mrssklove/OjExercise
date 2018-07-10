package 秋招2017;

import Model.ListNode;
import Model.TreeNode;

/**
 * 求长度  在对齐
 */
public class 二个链表的交叉 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        int lenA=0;
        int lenB=0;
        ListNode tempA=headA;
        ListNode tempB=headB;
        while (tempA!=null)
        {
            lenA++;
            tempA=tempA.next;
        }
        while (tempB!=null)
        {
            lenB++;
            tempB=tempB.next;
        }
        if(lenA>=lenB)
        {
            int move=lenA-lenB;
            while (move-->0) headA=headA.next;
        }
        else if(lenA<lenB)
        {
            int move=lenB-lenA;
            while (move-->0) headB=headB.next;
        }
        while (headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}
